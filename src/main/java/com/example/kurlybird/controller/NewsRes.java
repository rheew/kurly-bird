package com.example.kurlybird.controller;

import com.example.kurlybird.domain.news.News;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class NewsRes {

    private Long id;
    private String title;
    private String description;
    private String url;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime pubDate;

    public static NewsRes from(News news) {
        return new NewsRes(news.getId(), news.getTitle(), news.getDescription(), news.getUrl(), news.getPubDate());
    }
}
