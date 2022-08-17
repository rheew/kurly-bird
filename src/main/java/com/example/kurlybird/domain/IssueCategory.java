package com.example.kurlybird.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IssueCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public IssueCategory(String name) {
        this.name = name;
    }

    public static IssueCategory createIssueCategory(String name) {
        return new IssueCategory(name);
    }
}
