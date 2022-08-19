package com.example.kurlybird.repository;

import com.example.kurlybird.domain.category.IssueCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class IssueCategoryRepositoryTest {

    @Autowired
    private IssueCategoryRepository repository;

    @Test
    void 이슈카테고리_페치조인_조회() {
        final Optional<IssueCategory> result = repository.findById(1L);
        System.out.println(result);
    }
}
