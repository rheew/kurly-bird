package com.example.kurlybird.repository;

import com.example.kurlybird.domain.category.IssueCategory;
import com.example.kurlybird.domain.issue.Issue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class IssueRepositoryTest {

    @Autowired
    private IssueRepository repository;

    @Test
    void 카테고리_아이디로_최신등록가져오기() {
        final Issue issue = repository.findTopByIssueCategory_IdOrderByNewsDesc(1L).get();

        assertThat(issue.getNews().getId()).isEqualTo(2);
    }
}
