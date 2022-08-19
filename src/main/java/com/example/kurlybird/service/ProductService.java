package com.example.kurlybird.service;

import com.example.kurlybird.domain.product.Product;
import com.example.kurlybird.domain.product.ProductDetailRes;
import com.example.kurlybird.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDetailRes getDetail(Long productId) {
        final Product product = productRepository.findById(productId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 상품 입니다."));

        return ProductDetailRes.of(product);
    }
}