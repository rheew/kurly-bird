package com.example.kurlybird.domain.issue;

import com.example.kurlybird.domain.news.News;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime pubDate;

    public static IssueNewsRes from(Issue issue) {
        News news = issue.getNews();
        return new IssueNewsRes(issue.getId(), news.getTitle(), news.getDescription(), news.getUrl(), news.getPubDate());
    }
}
