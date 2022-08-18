package com.example.kurlybird.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
@Getter
public class Product extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "product")
    private List<ProductDetail> productDetails = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private IssueCategory issueCategory;

    public int getMinPrice() {
        return productDetails.stream()
                .mapToInt(item -> item.getPrice())
                .min()
                .orElseThrow(() -> new IllegalStateException("등록된 상품이 없습니다."));
    }
}
