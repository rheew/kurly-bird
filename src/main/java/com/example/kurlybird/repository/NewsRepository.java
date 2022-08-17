package com.example.kurlybird.repository;

import com.example.kurlybird.domain.news.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsRepository extends JpaRepository<News, Long> {

    Optional<News> findTopByOrderByPubDateDesc();
}
