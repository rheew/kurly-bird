package com.example.kurlybird.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PriceApiReq {

    private int itemCode;
    private LocalDate startDate;
    private LocalDate endDate;

    public static PriceApiReq createInitReq(int itemCode) {
        return new PriceApiReq(itemCode, LocalDate.now().minusMonths(1), LocalDate.now());
    }

    public static PriceApiReq createToDayReq(int itemCode) {
        return new PriceApiReq(itemCode, LocalDate.now(), LocalDate.now());
    }

    public String getStartDate() {
        return startDate.toString();
    }
    public String getEndDate() {
        return endDate.toString();
    }
}
