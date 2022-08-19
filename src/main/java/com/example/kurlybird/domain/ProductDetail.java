package com.example.kurlybird.domain;

import com.example.kurlybird.domain.Product;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;

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
