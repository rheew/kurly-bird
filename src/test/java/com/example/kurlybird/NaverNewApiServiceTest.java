package com.example.kurlybird;

import com.example.kurlybird.domain.news.NewsDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;

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
        final String query = URLEncoder.encode("사과", "UTF-8");
        String baseUrl = url + "?query=" + query;
        URI uri = URI.create(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity request = new HttpEntity(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("query", "사과");

        final String s = builder.toUriString();
//        %EC%82%AC%EA%B3%BC
        final String result = URLDecoder.decode("%EC%82%AC%EA%B3%BC", "UTF-8");

        ResponseEntity<NewsDto> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                NewsDto.class
        );
        System.out.println(response.getBody());
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }
}
