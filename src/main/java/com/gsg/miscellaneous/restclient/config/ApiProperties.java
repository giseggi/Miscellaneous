package com.gsg.miscellaneous.restclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "naverapi")
@Data
public class ApiProperties {
    String clientId;
    String clientSecret;
    Map<String, String> baseUrl;
}
