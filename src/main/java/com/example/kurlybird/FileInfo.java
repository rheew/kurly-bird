package com.example.kurlybird;

import com.example.kurlybird.domain.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class FileInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted;
}
