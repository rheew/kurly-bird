package com.example.kurlybird.domain.news;

import com.example.kurlybird.domain.issue.Issue;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class News {

    private static final int ONE_YEARS = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String url;

    @OneToOne
    private Issue issue;

    @Column(nullable = false)
    private LocalDateTime pubDate;

    private News(String title, String description, String url, LocalDateTime pubDate) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.pubDate = pubDate;
    }

    public News(LocalDateTime pubDate) {
        this.pubDate = pubDate;
    }

    public static News createNews(String title, String description, String url, LocalDateTime pubDate) {
        return new News(title, description, url, pubDate);
    }

    public static News createLastYearNews() {
        return new News(LocalDateTime.now().minusYears(ONE_YEARS));
    }
}
