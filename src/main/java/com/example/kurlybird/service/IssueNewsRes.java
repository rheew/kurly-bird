package com.example.kurlybird.service;

import com.example.kurlybird.domain.Issue;
import com.example.kurlybird.domain.news.News;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class IssueNewsRes {

    private Long issueId;
    private String title;
    private String description;
    private String url;
    private LocalDateTime pubDate;

    public static IssueNewsRes from(Issue issue) {
        News news = issue.getNews();
        return new IssueNewsRes(issue.getId(), news.getTitle(), news.getDescription(), news.getTitle(), news.getPubDate());
    }
}
