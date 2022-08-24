package com.example.kurlybird.controller;

import com.example.kurlybird.service.SmsSendService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value="문자발송 API", notes="입력한 대상자로 문자 발송하는 API")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/send")
    public ResponseEntity<String> sendSms(@RequestParam String sender) {
        service.sendOne(sender);
        return new ResponseEntity<>("200", HttpStatus.OK);
    }
}
