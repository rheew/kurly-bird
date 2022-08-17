package com.example.kurlybird.service;

import com.example.kurlybird.repository.IssueCategoryRepository;
import com.example.kurlybird.repository.NewsRepository;
import com.example.kurlybird.domain.news.News;
import com.example.kurlybird.domain.news.NaverNewsInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsService {
    private static final String ISSUE_KEYWORD_MATCHES = "(.*)상승(.*)||(.*)생산량 뚝(.*)||(.*)인상(.*)||(.*)껑충(.*)";

    private final NewsRepository newsRepository;
    private final NaverNewsApiService naverNewsApiService;

    public List<News> saveAll(List<News> news) {
        return newsRepository.saveAll(news);
    }

    public NaverNewsInfo getNaverNewsInfo(String name) {
        try {
            return naverNewsApiService.getNewsInfo(name);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<News> findIssueNews(NaverNewsInfo dto) {
        final Optional<News> latestSaveNews = newsRepository.findTopByOrderByPubDateDesc();

        return dto.getKeywordItems(ISSUE_KEYWORD_MATCHES).stream()
                .filter(item -> isAfter(latestSaveNews, item))
                .map(item -> News.createNews(item.getTitle(), item.getDescription(), item.getOriginalLink(), item.getPubDate()))
                .collect(Collectors.toList());
    }

    private boolean isAfter(Optional<News> latestSaveNews, NaverNewsInfo.Item item) {
        final News news = latestSaveNews.orElseGet(News::createLastYearNews);

        return news.getPubDate().isBefore(item.getPubDate());
    }
}
