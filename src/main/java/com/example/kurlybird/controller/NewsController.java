package com.example.kurlybird.controller;

import com.example.kurlybird.domain.news.NewsRes;
import com.example.kurlybird.service.NewsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @ApiOperation(value="뉴스 리스트 조회 API", notes="뉴스 페이지에 제공할 리스트 데이터 제공")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/news")
    public ResponseEntity<Page<NewsRes>> getNewsList(Pageable page) {
        return new ResponseEntity<>(newsService.getNewsList(page), HttpStatus.OK);
    }
}
