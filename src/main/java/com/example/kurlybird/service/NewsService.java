package com.example.kurlybird.service;

import com.example.kurlybird.domain.news.NewsRes;
import com.example.kurlybird.repository.NewsRepository;
import com.example.kurlybird.domain.news.News;
import com.example.kurlybird.domain.news.NaverNewsInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsService {
    private static final String ISSUE_KEYWORD_MATCHES = "(.*)상승(.*)||(.*)생산량 뚝(.*)||(.*)인상(.*)||(.*)껑충(.*)||" +
            "(.*)치솟는(.*)||(.*)비싸(.*)||(.*)급등(.*)||(.*)가격 폭등(.*)||(.*)오른다(.*)||(.*)오를(.*)||(.*)올렸다(.*)||(.*)올랐(.*)||" +
            "(.*)고공행진(.*)두배(.*)n배(.*)금값(.*)고물가(.*)金물가(.*)치솟아(.*)||" +
            "(.*)폭등(.*)||(.*)자연재해(.*)||(.*)가뭄(.*)||(.*)홍수(.*)||(.*)흉작(.*)||(.*)식품(.*)||(.*)수입문제(.*)";

    private final NewsRepository newsRepository;
    private final NaverNewsApiService naverNewsApiService;

    @Transactional
    public List<News> saveAll(List<News> news) {
        return newsRepository.saveAll(news);
    }

    public NaverNewsInfo getNaverNewsInfo(String name, int page) {
        try {
            return naverNewsApiService.getNewsInfo(name, page);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public List<News> findIssueNews(NaverNewsInfo dto) {
        final News latestSaveNews = newsRepository.findTopByOrderByPubDateDesc()
                .orElseGet(News::createLastYearNews);

        return dto.getKeywordItems(ISSUE_KEYWORD_MATCHES).stream()
                .filter(item -> isAfter(latestSaveNews, item))
                .map(item -> News.createNews(item.getTitle(), item.getDescription(), item.getOriginalLink(), item.getPubDate()))
                .collect(Collectors.toList());
    }

    private boolean isAfter(News latestSaveNews, NaverNewsInfo.Item item) {
        return latestSaveNews.getPubDate().isBefore(item.getPubDate());
    }

    public Page<NewsRes> getNewsList(Pageable pageable) {
        return newsRepository.findAll(pageable)
                .map(NewsRes::from);
    }
}
