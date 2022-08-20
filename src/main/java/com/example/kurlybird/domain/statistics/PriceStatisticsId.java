package com.example.kurlybird.domain.statistics;

import com.example.kurlybird.domain.category.IssueCategory;
import com.example.kurlybird.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PriceStatisticsId implements Serializable {

    private LocalDate regDate;

    private Long issueCategoryId;
}
