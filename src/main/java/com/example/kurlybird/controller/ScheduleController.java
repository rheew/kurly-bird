package com.example.kurlybird.controller;

import com.example.kurlybird.service.IssueService;
import com.example.kurlybird.service.PriceStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final IssueService issueService;
    private final PriceStatisticsService priceStatisticsService;

    @PostMapping("/issue")
    @ApiIgnore
    public ResponseEntity<?> postIssue() {
        issueService.saveIssue();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/price")
    public ResponseEntity<?> postPrice() {
        priceStatisticsService.saveInitStatistics();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
