package com.example.kurlybird.domain.statistics;

import com.example.kurlybird.domain.category.IssueCategory;
import com.example.kurlybird.domain.product.Product;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CategoryPriceCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int code;

    @OneToOne
    private IssueCategory issueCategory;
}
