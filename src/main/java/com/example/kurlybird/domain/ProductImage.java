package com.example.kurlybird.domain;

import com.example.kurlybird.domain.product.Product;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Product product;

    @OneToOne
    private FileInfo fileInfo;
}
