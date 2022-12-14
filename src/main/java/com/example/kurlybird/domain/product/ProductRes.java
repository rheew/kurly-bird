package com.example.kurlybird.domain.product;

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
    private String fileName;

    public static List<ProductRes> from(List<Product> products) {
        return products.stream()
                .map(product -> new ProductRes(product.getId(), product.getName(), product.getMinPrice(), product.getFileName()))
                .collect(Collectors.toList());
    }
}
