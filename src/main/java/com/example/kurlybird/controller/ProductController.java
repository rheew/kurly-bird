package com.example.kurlybird.controller;

import com.example.kurlybird.domain.product.ProductDetailRes;
import com.example.kurlybird.domain.statistics.PriceStatisticsRes;
import com.example.kurlybird.service.PriceStatisticsService;
import com.example.kurlybird.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    private final PriceStatisticsService priceStatisticsService;

    @ApiOperation(value="상품상세 API", notes="상품코드 값으로 상품 상세 정보를 조회하는 API")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDetailRes> getDetail(@PathVariable Long productId) {
        return new ResponseEntity<>(service.getDetail(productId), HttpStatus.OK);
    }

    @ApiOperation(value="상품가격통계 API", notes="카테고리 값으로 상품가격 통계 조회 API")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/product/price-info/{categoryId}")
    public ResponseEntity<List<PriceStatisticsRes>> getPriceInfo(@PathVariable Long categoryId) {
        return new ResponseEntity<>(priceStatisticsService.getInfos(categoryId), HttpStatus.OK);
    }
}
