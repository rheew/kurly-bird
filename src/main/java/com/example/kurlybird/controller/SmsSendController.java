package com.example.kurlybird.controller;

import com.example.kurlybird.service.SmsSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SmsSendController {
    private final SmsSendService service;

    @PostMapping("/send")
    public ResponseEntity<HttpStatus> sendSms(@RequestParam String sender) {
        service.sendOne(sender);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
