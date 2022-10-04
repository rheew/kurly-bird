package com.example.kurlybird.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
public class ScheduleService {
    private final IssueService issueService;
    private final PriceStatisticsService priceStatisticsService;

    //6시간마다 실행
//    @Scheduled(cron = "0 0 0/6 * * *")
//    @ApiIgnore
    @PostMapping("/123")
    public ResponseEntity<?> postIssue() {
        issueService.saveIssue();

        return new ResponseEntity<>(HttpStatus.OK);
    }
    // 매일 오후 3시 실행
//    @Scheduled(cron = "0 0 15 * * *")
//    @ApiIgnore
    @PostMapping("/1234")
    public ResponseEntity<?> postPrice() {
        priceStatisticsService.saveInitStatistics();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
