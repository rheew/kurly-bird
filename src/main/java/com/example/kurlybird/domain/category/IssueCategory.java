package com.example.kurlybird.domain.category;

import com.example.kurlybird.domain.BaseTimeEntity;
import com.example.kurlybird.domain.issue.Issue;
import com.example.kurlybird.domain.product.Product;
import com.example.kurlybird.domain.statistics.PriceStatistics;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IssueCategory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "issueCategory")
    private List<Issue> issues = new ArrayList<>();

    @OneToMany(mappedBy = "issueCategory")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "issueCategory")
    private List<PriceStatistics> priceStatistics = new ArrayList<>();

    //이슈가 있는 카테고리만 가져오기
    //이슈는 최근 한달내 생성된 이슈
    public boolean hasLastMonthIssue() {
        return issues.stream()
                    .anyMatch(issue -> issue.isLastMonth());
    }
}
