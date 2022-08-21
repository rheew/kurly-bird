package com.example.kurlybird.service;

import com.example.kurlybird.domain.category.IssueCategory;
import com.example.kurlybird.domain.issue.IssueNewsRes;
import com.example.kurlybird.domain.kurlybird.KurlyBirdRes;
import com.example.kurlybird.domain.product.ProductRes;
import com.example.kurlybird.repository.IssueCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KurlyBirdService {
    private final IssueCategoryRepository issueCategoryRepository;

    @Transactional(readOnly = true)
    public List<KurlyBirdRes> getList() {
        final List<IssueCategory> categories = issueCategoryRepository.findAll();

        return categories.stream()
                .filter(category -> category.hasLastMonthIssue())
                .map(KurlyBirdRes::ofIncreasePrice)
                .collect(Collectors.toList());
    }

    public KurlyBirdRes getKurlyBirdDetail(Long categoryId) {
        return issueCategoryRepository.findById(categoryId)
                .map(KurlyBirdRes::ofIncreasePrice)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 카테고리입니다."));
    }
}
