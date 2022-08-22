package com.example.kurlybird.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import springfox.documentation.annotations.ApiIgnore;

@Component
@RequiredArgsConstructor
public class ScheduleService {
    private final IssueService issueService;
    private final PriceStatisticsService priceStatisticsService;

    //6시간마다 실행
    @Scheduled(cron = "0 0 0/6 * * *")
    @ApiIgnore
    public ResponseEntity<?> postIssue() {
        issueService.saveIssue();

        return new ResponseEntity<>(HttpStatus.OK);
    }
    // 매일 오후 3시 실행
    @Scheduled(cron = "0 0 15 * * *")
    @ApiIgnore
    public ResponseEntity<?> postPrice() {
        priceStatisticsService.saveStatistics();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
