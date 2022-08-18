package com.example.kurlybird.service;

import com.example.kurlybird.domain.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRes {
    private Long id;
    private String name;
    private int price;

    public static List<ProductRes> from(List<Product> products) {
        return products.stream()
                .map(product -> new ProductRes(product.getId(), product.getName(), product.getMinPrice()))
                .collect(Collectors.toList());
    }
}
