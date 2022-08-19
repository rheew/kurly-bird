package com.example.kurlybird.domain.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDetailRes {

    private Long id;
    private String name;
    private String contents;
//    private String imageUrl;
    private int minPrice;
    private List<ProductDetailInfo> infos;
    private int totalStockQuantity;

    public static ProductDetailRes of(Product product) {
        return new ProductDetailRes(product.getId(), product.getName(),
                product.getContents(), product.getMinPrice(),
                ProductDetailInfo.from(product.getProductDetails()), product.getTotalStockQuantity());
    }
}
