package com.example.kurlybird.domain.issue;

import com.example.kurlybird.domain.BaseTimeEntity;
import com.example.kurlybird.domain.category.IssueCategory;
import com.example.kurlybird.domain.news.News;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Issue extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private News news;

    @ManyToOne(fetch = FetchType.LAZY)
    private IssueCategory issueCategory;

    private Issue(News news, IssueCategory issueCategory) {
        this.news = news;
        this.issueCategory = issueCategory;
    }

    public static List<Issue> createIssues(List<News> news, IssueCategory category) {
        return news.stream()
                .map(item -> new Issue(item, category))
                .collect(Collectors.toList());
    }

    public boolean isLastMonth() {
        final LocalDateTime lastMonth = LocalDateTime.now().minusMonths(1).minusDays(1);
        return lastMonth.isBefore(getCreatedDate());
    }
}
