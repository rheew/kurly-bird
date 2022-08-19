package com.example.kurlybird.service;

import com.example.kurlybird.domain.IssueCategory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KurlyBirdRes {

    public static final String SUBTITLE = "가격이 오를 것 같아요";
    public static final String TITLE = "지금 사면 좋은";
    public static final String EMPTY = " ";

    private List<IssueNewsRes> news;
    private List<ProductRes> products;
    private Long issueCategoryId;
    private String title;
    private String subtitle;

    public static KurlyBirdRes ofIncreasePrice(List<IssueNewsRes> issueNewsRes, List<ProductRes> productRes, IssueCategory issueCategory) {
        final String subtitle = issueCategory.getName() + EMPTY + SUBTITLE;
        final String title = TITLE + EMPTY + issueCategory.getName();

        return new KurlyBirdRes(issueNewsRes, productRes, issueCategory.getId(), title, subtitle);
    }
}
