package com.example.kurlybird.controller;

import com.example.kurlybird.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;

    @PostMapping("/issue")
    @ApiIgnore
    public ResponseEntity<?> postIssue() {
        issueService.saveIssue();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
