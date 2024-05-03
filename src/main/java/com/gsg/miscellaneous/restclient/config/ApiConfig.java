package com.gsg.miscellaneous.restclient.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
@RequiredArgsConstructor
public class ApiConfig {

    private final ApiProperties apiProperties;

    @Bean
    @Primary
    public RestClient naverSearch() {
        return RestClient.builder()
                .requestFactory(new SimpleClientHttpRequestFactory())
                .baseUrl(apiProperties.getBaseUrl().get("search"))
                .defaultHeader("X-Naver-Client-Id", apiProperties.getClientId())
                .defaultHeader("X-Naver-Client-Secret", apiProperties.getClientSecret())
                .build();
    }
}
