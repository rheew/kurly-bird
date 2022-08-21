package com.example.kurlybird.service;

import com.example.kurlybird.domain.issue.Issue;
import com.example.kurlybird.repository.IssueCategoryRepository;
import com.example.kurlybird.domain.category.IssueCategory;
import com.example.kurlybird.domain.news.News;
import com.example.kurlybird.domain.news.NaverNewsInfo;
import com.example.kurlybird.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class IssueService {

    private static final Logger logger = LoggerFactory.getLogger(IssueService.class);

    private final IssueCategoryRepository issueCategoryRepository;
    private final NewsService newsService;
    private final IssueRepository issueRepository;

    @Transactional
    public void saveIssue() {
        final List<IssueCategory> categories = issueCategoryRepository.findAll();

        categories.stream()
                .forEach(category -> {
                    final NaverNewsInfo naverNewsInfo = newsService.getNaverNewsInfo(category.getName(), 1);
                    final List<News> news = newsService.saveAll(newsService.findIssueNews(naverNewsInfo));

                    if (news.size() > 0) {
                        final List<Issue> issues = issueRepository.saveAll(Issue.createIssues(news, category));
                        logger.debug("저장된 이슈 갯수: {}", issues.size());
                    }
                });
    }

    @Transactional
    public void saveInitIssue() {
        final List<IssueCategory> categories = issueCategoryRepository.findAll();

        categories.stream()
                .forEach(category -> {
                    final NaverNewsInfo naverNewsInfo = new NaverNewsInfo();
                    for(int i = 1; i <= 10; i++) {
                        naverNewsInfo.addItems(newsService.getNaverNewsInfo(category.getName(), i));
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    final List<News> news = newsService.saveAll(newsService.findIssueNews(naverNewsInfo));

                    if (news.size() > 0) {
                        final List<Issue> issues = issueRepository.saveAll(Issue.createIssues(news, category));
                        logger.debug("저장된 이슈 갯수: {}", issues.size());
                    }
                });
    }
}
