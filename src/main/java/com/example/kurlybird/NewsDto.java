package com.example.kurlybird;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NewsDto {
    @JsonProperty("lastBuildDate")
    private String lastBuildDate;
    @JsonProperty("total")
    private String total;
    @JsonProperty("start")
    private String start;
    @JsonProperty("display")
    private String display;
    @JsonProperty("items")
    private List<Item> items;

    static class Item {
        @JsonProperty("title")
        private String title;

        @JsonProperty("originallink")
        private String originalLink;

        @JsonProperty("link")
        private String link;

        @JsonProperty("description")
        private String description;

        @JsonProperty("pubDate")
        private String pubDate;
    }
}
