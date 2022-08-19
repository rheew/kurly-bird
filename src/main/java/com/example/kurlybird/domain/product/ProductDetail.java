package com.example.kurlybird.domain.product;

import com.example.kurlybird.domain.BaseTimeEntity;
import com.example.kurlybird.domain.product.Product;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class ProductDetail extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int stockQuantity = 0;
}
