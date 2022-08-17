package com.example.kurlybird.service;

import com.example.kurlybird.Repository.IssueCategoryRepository;
import com.example.kurlybird.Repository.NewsRepository;
import com.example.kurlybird.domain.IssueCategory;
import com.example.kurlybird.domain.news.NewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final IssueCategoryRepository issueCategoryRepository;
    private final NewsRepository newsRepository;
    private final NaverNewsApiService naverNewsApiService;

    public void saveNewsInfo() {
        final List<IssueCategory> categories = issueCategoryRepository.findAll();

//        categories.stream()
//                .map(category -> {
//                    final NewsDto newsDto = getNewsDto(category.getName());
//                    return;
//                });

        // 지금 검색하고 있는 키워드 정보를 가지고 있어야 저장할 수 있다.
    }

    private NewsDto getNewsDto(String name) {
        try {
            return naverNewsApiService.getNewsInfo(name);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
