package com.example.kurlybird.domain.product;

import com.example.kurlybird.domain.BaseTimeEntity;
import com.example.kurlybird.domain.ProductImage;
import com.example.kurlybird.domain.category.IssueCategory;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String contents;

    @OneToMany(mappedBy = "product")
    private List<ProductDetail> productDetails = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private IssueCategory issueCategory;

    @OneToOne(mappedBy = "product")
    @JoinColumn(name = "id")
    private ProductImage productImage;

    public int getMinPrice() {
        return productDetails.stream()
                .mapToInt(item -> item.getPrice())
                .min()
                .orElseThrow(() -> new IllegalStateException("등록된 상품이 없습니다."));
    }

    public int getTotalStockQuantity() {
        return productDetails.stream()
                .map(ProductDetail::getStockQuantity)
                .mapToInt(i -> i)
                .sum();
    }

    public Long getIssueCategoryId() {
        return issueCategory.getId();
    }

    public String getFileName() {
        return productImage.getFileInfo().getName();
    }
}
