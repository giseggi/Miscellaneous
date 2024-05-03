package com.gsg.miscellaneous.restclient.service.impl;

import com.gsg.miscellaneous.restclient.service.NaverSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NaverSearchServiceImpl implements NaverSearchService {

    private final RestClient restClient;

    @Override
    public String callNaverSearchApi(String query, Integer display, Integer start, String sort) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("query", query).build())
                .retrieve().toEntity(String.class).toString();
    }
}
