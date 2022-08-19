package com.example.kurlybird.domain.kurlybird;

import com.example.kurlybird.domain.category.IssueCategory;
import com.example.kurlybird.domain.issue.IssueNewsRes;
import com.example.kurlybird.domain.product.ProductRes;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KurlyBirdRes {

    private static final String SUBTITLE = "가격이 오를 것 같아요";
    private static final String TITLE = "지금 사면 좋은";
    private static final String EMPTY = " ";

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
