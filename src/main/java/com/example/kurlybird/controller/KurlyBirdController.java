package com.example.kurlybird.controller;

import com.example.kurlybird.service.KurlyBirdRes;
import com.example.kurlybird.service.KurlyBirdService;
import com.example.kurlybird.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class KurlyBirdController {
    private final KurlyBirdService kurlyBirdService;

    @GetMapping("/kurly-bird")
    public ResponseEntity<?> getKurlyBirdList() {
        final List<KurlyBirdRes> result = kurlyBirdService.getList();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
