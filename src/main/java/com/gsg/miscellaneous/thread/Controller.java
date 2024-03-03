package com.gsg.miscellaneous.thread;

import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StopWatch;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/thread")
@RequiredArgsConstructor
@Slf4j
public class Controller {

    private final ThreadExample threadExample;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10); // 쓰레드 풀 생성 (최대 10개의 스레드를 가짐)

    @PostMapping("/withoutThread")
    public String exampleWithoutThread(@RequestParam List<String> params) throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (String param : params) {
            threadExample.example(param);
        }
        stopWatch.stop();
        log.info("총 소요 시간: " + stopWatch.getTotalTimeMillis() + "ms");
        return "finished :)";
    }

    @PostMapping("/withThread")
    public String exampleWithThread(@RequestParam List<String> params) throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 각 요청을 쓰레드 풀에 제출하여 병렬로 처리
        for (String param : params) {
            executorService.submit(() -> {
                try {
                    threadExample.example(param);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                log.info(param + " 작업 완료");
            }); // 쓰레드 풀에서 실행될 작업을 제출
        }

        stopWatch.stop();
        log.info("총 소요 시간: " + stopWatch.getTotalTimeMillis() + "ms");

        // 모든 작업이 완료될 때까지 대기
        executorService.shutdown(); // 쓰레드 풀 종료
        while (!executorService.isTerminated()) {
            // 대기
        }

        return "finished :)";
    }
}


//curl -X POST http://localhost:8080/thread/withThread \
//        -H "application/x-www-form-urlencoded" \
//        -d 'params=test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test,test'
