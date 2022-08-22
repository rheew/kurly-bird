package com.example.kurlybird.domain;

import com.example.kurlybird.FileInfo;

import javax.persistence.*;

@Entity
public class ProductImage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private FileInfo fileInfo;
}
