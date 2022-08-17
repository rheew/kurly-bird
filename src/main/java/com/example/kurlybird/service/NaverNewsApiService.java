package com.example.kurlybird.service;

import com.example.kurlybird.domain.news.NewsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

@Service
public class NaverNewsApiService {

    public static final int SUCCESS_STATUS = 200;

    @Value("${naver.client.secret}")
    private String clientSecret;
    @Value("${naver.client.id}")
    private String clientId;
    @Value("${naver.openapi.url}")
    private String url;

    public NewsDto getNewsInfo(String keyword) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        final String query = URLEncoder.encode(keyword, "UTF-8");
        final String baseUrl = url + "query=" + query;

        URI uri = URI.create(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<NewsDto> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                NewsDto.class
        );

        if (isSuccessStatus(response)) {
            throw new IllegalStateException("네이버 검색 API 호출이 실패했습니다.");
        }
        return response.getBody();
    }

    private boolean isSuccessStatus(ResponseEntity<NewsDto> response) {
        return response.getStatusCodeValue() != SUCCESS_STATUS;
    }
}
