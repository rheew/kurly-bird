package com.example.kurlybird.domain.news;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
public class NewsDto {
    @JsonProperty("lastBuildDate")
    @JsonFormat(pattern = "EEE, dd MMM yyyy HH:mm:ss Z", locale = "ENGLISH")
    private LocalDateTime lastBuildDate;
    @JsonProperty("total")
    private String total;
    @JsonProperty("start")
    private String start;
    @JsonProperty("display")
    private String display;
    @JsonProperty("items")
    private List<Item> items;

    public static class Item {
        @JsonProperty("title")
        private String title;

        @JsonProperty("originallink")
        private String originalLink;

        @JsonProperty("link")
        private String link;

        @JsonProperty("description")
        private String description;

        @JsonProperty("pubDate")
        @JsonFormat(pattern = "EEE, dd MMM yyyy HH:mm:ss Z", locale = "ENGLISH")
        private LocalDateTime pubDate;
    }
}
