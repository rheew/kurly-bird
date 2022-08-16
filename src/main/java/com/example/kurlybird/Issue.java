package com.example.kurlybird;

import javax.persistence.*;

@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private News news;

    @OneToOne
    private IssueCategory category;
}
