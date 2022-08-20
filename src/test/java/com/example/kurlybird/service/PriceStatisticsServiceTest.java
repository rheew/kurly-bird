package com.example.kurlybird.service;

import com.example.kurlybird.domain.statistics.PriceStatisticsInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PriceStatisticsServiceTest {

    @Value("${price.client.secret}")
    private String clientSecret;
    @Value("${price.client.id}")
    private String clientId;
    @Value("${price.openapi.url}")
    private String url;

    @Test
    void 가격_API_정상동작확인() throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("action", "periodProductList")
                .queryParam("p_cert_key", clientSecret)
                .queryParam("p_cert_id", clientId)
                .queryParam("p_returntype", "json")
                .queryParam("p_startday", "2022-07-18")
                .queryParam("p_endday", "2022-08-19")
                .queryParam("p_itemcode", 414)
                .queryParam("p_countrycode", 1101);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request,body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });

        HttpEntity<PriceStatisticsInfo> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                PriceStatisticsInfo.class);

        assertThat(response.getBody().isSuccess()).isTrue();
    }
}
