package com.example.kurlybird.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
@RestController
@RequiredArgsConstructor
public class ScheduleService {
    private final IssueService issueService;
    private final PriceStatisticsService priceStatisticsService;

    //6시간마다 실행
    @PostMapping("/123")
    public ResponseEntity<?> postIssue() {
        issueService.saveIssue();

        return new ResponseEntity<>(HttpStatus.OK);
    }
    // 매일 오후 3시 실행
    @PostMapping("/1234")
    public ResponseEntity<?> postPrice() {
        priceStatisticsService.saveInitStatistics();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
