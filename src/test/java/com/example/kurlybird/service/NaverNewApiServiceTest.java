package com.example.kurlybird.service;

import com.example.kurlybird.domain.news.NaverNewsInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class NaverNewApiServiceTest {

    @Value("${naver.client.secret}")
    private String clientSecret;
    @Value("${naver.client.id}")
    private String clientId;
    @Value("${naver.openapi.url}")
    private String url;

    @Test
    void 뉴스_API_정상동작확인() throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        final String query = URLEncoder.encode("수박", "UTF-8");
        String baseUrl = url + "?query=" + query + "&display=" + 100 + "&start=" + 10;
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
        System.out.println(response.getBody());
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void 비동기() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32); //
        CountDownLatch latch = new CountDownLatch(threadCount); // 메인쓰레드가 다른 스레드 작업이 끝날때 까지 기다려 주기 위해 사용했다.

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    System.out.print("실행");
                } finally {
                    latch.countDown();
                }
            });
        }
        System.out.println("#$#$@%!$#%!$#%#$%f비동기");
        latch.await();
    }
}
