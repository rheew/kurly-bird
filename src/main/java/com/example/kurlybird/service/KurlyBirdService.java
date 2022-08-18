package com.example.kurlybird.service;

import com.example.kurlybird.domain.IssueCategory;
import com.example.kurlybird.repository.IssueCategoryRepository;
import com.example.kurlybird.repository.ProductRepository;
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

                            return KurlyBirdRes.of(issueNewsRes, productRes, category.getId()); })
                .collect(Collectors.toList());
    }
}
