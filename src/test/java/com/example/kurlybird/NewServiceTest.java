package com.example.kurlybird;

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

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@TestPropertySource(locations = "classpath:application.yml")
//@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NewServiceTest {

    @Value("${naver.client.secret}")
    private String clientSecret;
    @Value("${naver.client.id}")
    private String clientId;

    @Test
    void 뉴스_API_정상동작확인() throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        final String query = URLEncoder.encode("배", "UTF-8");
        String baseUrl = "https://openapi.naver.com/v1/search/news.json?query=" + query;
        URI uri = URI.create(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                String.class
        );
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }
}
