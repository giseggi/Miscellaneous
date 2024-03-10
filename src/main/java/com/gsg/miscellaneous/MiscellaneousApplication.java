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
        JvmMetrics.builder().register(); // initialize the out-of-the-box JVM metrics

        Gauge gauge = Gauge.builder()
                .name("my_gauge_test")
                .help("example counter")
                .labelNames("status", "type")
                .register();

        gauge.labelValues("ok", "A").inc();
        gauge.labelValues("ng", "B").inc();
        gauge.labelValues("ng", "O").inc();
        gauge.labelValues("ok", "AB").inc();
        gauge.labelValues("ok", "A").inc();
        gauge.labelValues("error", "B").inc();

        HTTPServer server = HTTPServer.builder()
                .port(9400)
                .buildAndStart();

        System.out.println("HTTPServer listening on port http://localhost:" + server.getPort() + "/metrics");

        Thread.currentThread().join(); // sleep forever
        SpringApplication.run(MiscellaneousApplication.class, args);
    }

}
