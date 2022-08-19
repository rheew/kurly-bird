package com.example.kurlybird.service;

import com.example.kurlybird.domain.category.IssueCategory;
import com.example.kurlybird.domain.issue.IssueNewsRes;
import com.example.kurlybird.domain.kurlybird.KurlyBirdRes;
import com.example.kurlybird.domain.product.ProductRes;
import com.example.kurlybird.repository.IssueCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KurlyBirdService {
    private final IssueCategoryRepository issueCategoryRepository;

    public List<KurlyBirdRes> getList() {
        final List<IssueCategory> categories = issueCategoryRepository.findAll();

        return categories.stream()
                .filter(category -> category.hasLastMonthIssue())
                .map(category -> {
                            final List<IssueNewsRes> issueNewsRes = category.getIssues().stream()
                                    .map(IssueNewsRes::from)
                                    .collect(Collectors.toList());

                            final List<ProductRes> productRes = ProductRes.from(category.getProducts());

                            return KurlyBirdRes.ofIncreasePrice(issueNewsRes, productRes, category); })
                .collect(Collectors.toList());
    }
}
