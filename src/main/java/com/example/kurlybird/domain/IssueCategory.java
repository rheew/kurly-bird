package com.example.kurlybird.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class IssueCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
