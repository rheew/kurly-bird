package com.example.kurlybird.service;

import com.example.kurlybird.domain.statistics.PriceStatistics;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PriceStatisticsRes {

    private String price;
    private Long categoryId;
    private LocalDate date;

    public static List<PriceStatisticsRes> fromInfos(List<PriceStatistics> statistics) {
        return statistics.stream()
                .map(item -> new PriceStatisticsRes(item.getPrice(), item.getCategoryId(), item.getRegDate()))
                .collect(Collectors.toList());
    }
}