package com.example.kurlybird.domain.statistics;

import com.example.kurlybird.domain.category.IssueCategory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PriceStatistics {

    private static final String COMMA = ",";
    private static final int TRANSFORM_100G = 40;

    @EmbeddedId
    private PriceStatisticsId id;

    private String price;

    private String place;

    @MapsId("issueCategoryId")
    @ManyToOne(fetch = FetchType.LAZY)
    private IssueCategory issueCategory;

    public PriceStatistics(String price) {
        this.price = price;
    }

    public static List<PriceStatistics> ofInfos(PriceStatisticsInfo info, IssueCategory category) {
        //item 마다 한개씩 등록 할 예정  결과가 list 객체
        return info.getItems().stream()
            .map(item -> {
                final PriceStatisticsId priceStatisticsId = new PriceStatisticsId(item.getRegDate(), category.getId());
                return new PriceStatistics(priceStatisticsId, item.getPrice(), item.getCountryName(), category);
            }).collect(Collectors.toList());
    }

    public Long getCategoryId() {
        return id.getIssueCategoryId();
    }

    public LocalDate getRegDate() {
        return id.getRegDate();
    }

    public int getPriceToInt() {
        return to100gPrice(parseInt(getPriceRemoveComma()));
    }

    private String getPriceRemoveComma() {
        return price.replaceAll(COMMA, "");
    }

    private int parseInt(String price) {
        return Integer.parseInt(price);
    }

    private int to100gPrice(int price) {
        return price / TRANSFORM_100G;
    }
}
