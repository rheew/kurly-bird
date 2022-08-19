package com.example.kurlybird.controller;

import com.example.kurlybird.domain.kurlybird.KurlyBirdRes;
import com.example.kurlybird.service.KurlyBirdService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class KurlyBirdController {
    private final KurlyBirdService kurlyBirdService;

    @ApiOperation(value="컬리버드 조회 API", notes="컬리버드 페이지에 제공할 API 리스트 데이터 제공")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/kurly-bird")
    public ResponseEntity<?> getKurlyBirdList() {
        final List<KurlyBirdRes> result = kurlyBirdService.getList();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
