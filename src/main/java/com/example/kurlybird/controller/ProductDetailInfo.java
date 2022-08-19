package com.example.kurlybird.controller;

import com.example.kurlybird.domain.ProductDetail;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDetailInfo {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    public static List<ProductDetailInfo> from(List<ProductDetail> productDetails) {
        return productDetails.stream()
                .map(item -> new ProductDetailInfo(item.getId(), item.getName(), item.getPrice(), item.getStockQuantity()))
                .collect(Collectors.toList());
    }
}
