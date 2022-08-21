package com.example.kurlybird.service;

import com.example.kurlybird.domain.news.NaverNewsInfo;
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

    private static final int SUCCESS_STATUS = 200;

    @Value("${naver.client.secret}")
    private String clientSecret;
    @Value("${naver.client.id}")
    private String clientId;
    @Value("${naver.openapi.url}")
    private String url;

    public NaverNewsInfo getNewsInfo(String keyword, int page) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        final String query = URLEncoder.encode(keyword, "UTF-8");
        final String baseUrl = url + "?query=" + query + "&display=" + 100 + "&start=" + page;

        URI uri = URI.create(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<NaverNewsInfo> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                NaverNewsInfo.class
        );

        if (isSuccessStatus(response)) {
            throw new IllegalStateException("네이버 검색 API 호출이 실패했습니다.");
        }
        return response.getBody();
    }

    private boolean isSuccessStatus(ResponseEntity<NaverNewsInfo> response) {
        return response.getStatusCodeValue() != SUCCESS_STATUS;
    }
}
