package com.example.kurlybird.repository;

import com.example.kurlybird.domain.news.News;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class NewsRepositoryTest {

    @Autowired
    private NewsRepository repository;

    @Test
    void 페이징된_리스트를_가져온다() {

        final Page<News> result = repository.findAll(PageRequest.of(0, 10));

        assertThat(result.getContent().size()).isEqualTo(4);
    }
}
