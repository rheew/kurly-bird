package com.example.kurlybird.domain.statistics;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PriceStatisticsRes {

    private int price;
    private Long categoryId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate date;

    public static List<PriceStatisticsRes> fromTwoWeekInfos(List<PriceStatistics> statistics) {

        return statistics.stream()
                .filter(item -> item.getRegDate().isAfter(LocalDate.now().minusWeeks(2).minusDays(1)))
                .map(item -> new PriceStatisticsRes(item.getPriceToInt(), item.getCategoryId(), item.getRegDate()))
                .collect(Collectors.toList());
    }
}