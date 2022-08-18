package com.example.kurlybird.repository;

import com.example.kurlybird.domain.news.News;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class NewsTest {

    @Autowired
    private NewsRepository repository;

    @Test
    void 최신뉴스_하나_가져온다() {
        final List<News> news = Arrays.asList(
                News.createNews("1", "1", "1", createLocalDateTime(1)),
                News.createNews("1", "1", "1", createLocalDateTime(2)),
                News.createNews("1", "1", "1", createLocalDateTime(3)));

        repository.saveAll(news);
        final News news1 = repository.findTopByOrderByPubDateDesc().get();

        assertThat(news1.getPubDate()).isEqualTo(createLocalDateTime(3));
    }

    private LocalDateTime createLocalDateTime(int minute) {
        return LocalDateTime.of(1, 1, 1, 1, minute);
    }
}
