package com.example.kurlybird.domain.news;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class NaverNewsInfo {
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
    private List<Item> items = new ArrayList<>();

    @Getter
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
    public void addItems(NaverNewsInfo info) {
        items.addAll(info.getItems());
    }

    public List<Item> getKeywordItems(String keywordMatches) {
        return items.stream()
                .filter(item -> isMatchesItem(item, keywordMatches))
                .collect(Collectors.toList());
    }

    public boolean isMatchesItem(Item item, String keywordMatches) {
        return item.description.matches(keywordMatches) || item.title.matches(keywordMatches);
    }

}
