package com.example.kurlybird.domain;

import com.example.kurlybird.domain.Product;

import javax.persistence.*;

@Entity
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
