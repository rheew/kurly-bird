package com.example.kurlybird.service;

import com.example.kurlybird.domain.statistics.CategoryPriceCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryPriceCodeRepository extends JpaRepository<CategoryPriceCode, Long> {
}
