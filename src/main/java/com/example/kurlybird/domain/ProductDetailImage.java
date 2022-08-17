package com.example.kurlybird.domain;

import com.example.kurlybird.File;
import com.example.kurlybird.domain.ProductDetail;

import javax.persistence.*;

@Entity
public class ProductDetailImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductDetail productDetail;

    @OneToOne
    private File file;
}
