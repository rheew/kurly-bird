package com.example.kurlybird.repository;

import com.example.kurlybird.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
