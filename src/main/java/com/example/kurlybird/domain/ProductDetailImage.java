package com.example.kurlybird.domain;

import com.example.kurlybird.FileInfo;
import com.example.kurlybird.domain.product.ProductDetail;

import javax.persistence.*;

@Entity
public class ProductDetailImage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductDetail productDetail;

    @OneToOne
    private FileInfo fileInfo;
}
