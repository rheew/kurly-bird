package com.example.kurlybird.repository;

import com.example.kurlybird.domain.product.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void 상품조회() {
        final List<Product> products = repository.findAll();
        assertThat(products.size()).isEqualTo(17);
    }
}