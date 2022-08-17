package com.example.kurlybird;

import com.example.kurlybird.domain.news.NaverNewsInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
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
        String baseUrl = url + "?query=" + query + "&display=" + 100;
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
}
