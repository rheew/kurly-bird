package com.example.kurlybird.service;

import com.example.kurlybird.domain.category.IssueCategory;
import com.example.kurlybird.domain.statistics.*;
import com.example.kurlybird.repository.CategoryPriceCodeRepository;
import com.example.kurlybird.repository.IssueCategoryRepository;
import com.example.kurlybird.repository.PriceStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceStatisticsService {
    private final PriceStatisticsRepository repository;
    private final CategoryPriceCodeRepository categoryPriceCodeRepository;
    private final PriceStatisticsApiService service;
    private final IssueCategoryRepository issueCategoryRepository;

    @Transactional(readOnly = true)
    public List<PriceStatisticsRes> getInfos(Long categoryId) {
        final IssueCategory issueCategory = issueCategoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));

        return PriceStatisticsRes.fromTwoWeekInfos(issueCategory.getPriceStatistics());
    }

    @Transactional
    public void saveStatistics() {
        final List<CategoryPriceCode> codes = categoryPriceCodeRepository.findAll();
        codes.stream()
                .forEach(code -> {
                    final PriceStatisticsInfo info = service.getPriceStatisticsInfo(PriceApiReq.createToDayReq(code.getCode()));
                    final List<PriceStatistics> priceStatistics = PriceStatistics.ofInfos(info, code.getIssueCategory());
                    repository.saveAll(priceStatistics);
                });
    }

    @Transactional
    public void saveInitStatistics() {
        final List<CategoryPriceCode> codes = categoryPriceCodeRepository.findAll();
        codes.stream()
                .forEach(code -> {
                    final PriceStatisticsInfo info = service.getPriceStatisticsInfo(PriceApiReq.createInitReq(code.getCode()));
                    final List<PriceStatistics> priceStatistics = PriceStatistics.ofInfos(info, code.getIssueCategory());
                    repository.saveAll(priceStatistics);
                });
    }
}
