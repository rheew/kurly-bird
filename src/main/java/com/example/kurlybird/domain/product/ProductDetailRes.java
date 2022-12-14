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
    private Long issueCategoryId;
    private String name;
    private String contents;
    private String fileName;
    private int minPrice;
    private List<ProductDetailInfo> infos;
    private int totalStockQuantity;

    public static ProductDetailRes of(Product product) {
        return new ProductDetailRes(
                product.getId(), product.getIssueCategoryId(),
                product.getName(), product.getContents(),
                product.getFileName(), product.getMinPrice(),
                ProductDetailInfo.from(product.getProductDetails()), product.getTotalStockQuantity());
    }
}
