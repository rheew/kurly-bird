package com.example.kurlybird.repository;

import com.example.kurlybird.domain.statistics.PriceStatistics;
import com.example.kurlybird.domain.statistics.PriceStatisticsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceStatisticsRepository extends JpaRepository<PriceStatistics, PriceStatisticsId> {
}
