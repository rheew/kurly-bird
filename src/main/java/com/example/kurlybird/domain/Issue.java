package com.example.kurlybird.domain;

import com.example.kurlybird.domain.news.News;

import javax.persistence.*;

@Entity
public class Issue extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private News news;

    @OneToOne
    private IssueCategory category;
}
