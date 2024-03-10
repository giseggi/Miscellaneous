package com.gsg.miscellaneous;

import io.prometheus.metrics.core.metrics.Counter;
import io.prometheus.metrics.core.metrics.Gauge;
import io.prometheus.metrics.exporter.httpserver.HTTPServer;
import io.prometheus.metrics.instrumentation.jvm.JvmMetrics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MiscellaneousApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
//        JvmMetrics.builder().register(); // initialize the out-of-the-box JVM metrics
//
//        Gauge gauge = Gauge.builder()
//                .name("my_gauge_test")
//                .help("example counter")
//                .labelNames("status")
//                .register();
//
//        gauge.labelValues("ok").inc();
//        gauge.labelValues("ng").inc();
//        gauge.labelValues("ng").inc();
//        gauge.labelValues("ok").inc();
//        gauge.labelValues("ok").inc();
//        gauge.labelValues("error").inc();
//
//        HTTPServer server = HTTPServer.builder()
//                .port(9400)
//                .buildAndStart();
//
//        System.out.println("HTTPServer listening on port http://localhost:" + server.getPort() + "/metrics");
//
//        Thread.currentThread().join(); // sleep forever
        SpringApplication.run(MiscellaneousApplication.class, args);
    }

}
