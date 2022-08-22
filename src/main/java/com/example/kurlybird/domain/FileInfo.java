package com.example.kurlybird.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class FileInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted;
}
