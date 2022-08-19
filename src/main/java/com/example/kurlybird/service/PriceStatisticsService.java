package com.example.kurlybird.service;

import com.example.kurlybird.domain.statistics.CategoryPriceCode;
import com.example.kurlybird.domain.statistics.PriceApiReq;
import com.example.kurlybird.domain.statistics.PriceStatistics;
import com.example.kurlybird.domain.statistics.PriceStatisticsInfo;
import com.example.kurlybird.repository.PriceStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceStatisticsService {
    private final PriceStatisticsRepository repository;
    private final CategoryPriceCodeRepository categoryPriceCodeRepository;
    private final PriceStatisticsApiService service;

    public void saveStatistics() {
        final List<CategoryPriceCode> codes = categoryPriceCodeRepository.findAll();
        codes.stream()
                .forEach(code -> {
                    final PriceStatisticsInfo info = service.getPriceStatisticsInfo(PriceApiReq.createToDayReq(code.getCode()));
                    final List<PriceStatistics> priceStatistics = PriceStatistics.ofInfos(info, code.getIssueCategory());
                    repository.saveAll(priceStatistics);
                });
    }

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
