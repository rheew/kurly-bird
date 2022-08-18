package com.example.kurlybird.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KurlyBirdRes {

    private List<IssueNewsRes> news;
    private List<ProductRes> products;
    private Long issueCategoryId;

    public static KurlyBirdRes of(List<IssueNewsRes> issueNewsRes, List<ProductRes> productRes, Long issueCategoryId) {
        return new KurlyBirdRes(issueNewsRes, productRes, issueCategoryId);
    }
}
