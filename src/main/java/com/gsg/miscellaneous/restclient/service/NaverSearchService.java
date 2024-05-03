package com.gsg.miscellaneous.restclient.service;

import org.springframework.http.ResponseEntity;

import java.util.*;

public interface NaverSearchService {

    String callNaverSearchApi(String query, Integer display, Integer start, String sort);
}
