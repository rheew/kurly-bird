package com.example.kurlybird.service;

import com.example.kurlybird.domain.statistics.PriceApiReq;
import com.example.kurlybird.domain.statistics.PriceStatisticsInfo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PriceStatisticsApiService {
    private static final Logger logger = LoggerFactory.getLogger(PriceStatisticsApiService.class);

    @Value("${price.client.secret}")
    private String clientSecret;
    @Value("${price.client.id}")
    private String clientId;
    @Value("${price.openapi.url}")
    private String url;

    public PriceStatisticsInfo getPriceStatisticsInfo(PriceApiReq req) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("action", "periodProductList")
                .queryParam("p_cert_key", clientSecret)
                .queryParam("p_cert_id", clientId)
                .queryParam("p_returntype", "json")
                .queryParam("p_startday", req.getStartDate())
                .queryParam("p_endday", req.getEndDate())
                .queryParam("p_itemcode", req.getItemCode())
                .queryParam("p_countrycode", 1101);

        restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request, body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });

        logger.debug("가격정보 API 요청 : {}", builder.toUriString());

        HttpEntity<PriceStatisticsInfo> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                PriceStatisticsInfo.class);

        if (!response.getBody().isSuccess()) {
            throw new IllegalStateException("가격정보를 가져오는데 실패했습니다.");
        }
        return response.getBody();
    }
}
