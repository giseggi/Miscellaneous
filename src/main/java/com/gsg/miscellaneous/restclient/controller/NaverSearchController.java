package com.gsg.miscellaneous.restclient.controller;

import com.gsg.miscellaneous.restclient.service.NaverSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/naver")
@RequiredArgsConstructor
@Slf4j
public class NaverSearchController {

    private final NaverSearchService naverSearchService;

    @PostMapping(value = "/search")
    String callSearchApi() {
        return naverSearchService.callNaverSearchApi("%EB%A7%A5%EB%B6%81", 10, 1, "sim");
    }
}
