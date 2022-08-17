package com.example.kurlybird.domain;

import com.example.kurlybird.domain.news.News;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Issue extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private News news;

    @OneToOne
    private IssueCategory category;

    private Issue(News news, IssueCategory category) {
        this.news = news;
        this.category = category;
    }

    public static List<Issue> createIssues(List<News> news, IssueCategory category) {
        return news.stream()
                .map(item -> new Issue(item, category))
                .collect(Collectors.toList());
    }
}
