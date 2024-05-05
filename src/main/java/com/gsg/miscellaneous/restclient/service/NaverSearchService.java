package com.gsg.miscellaneous.restclient.service;

import com.gsg.miscellaneous.restclient.entity.SearchResponse;
import org.springframework.http.ResponseEntity;

import java.util.*;

public interface NaverSearchService {

    ResponseEntity<SearchResponse> callNaverSearchApi(String query, Integer display, Integer start, String sort);
}
