package com.example.kurlybird.domain;

import com.example.kurlybird.domain.statistics.PriceStatistics;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceStatisticsTest {

    @Test
    void 가격정보_Int로_가져온다() {
        final PriceStatistics priceStatistics = new PriceStatistics("1,101,000");

        assertThat(priceStatistics.getPriceToInt()).isEqualTo(27525);
    }
}
