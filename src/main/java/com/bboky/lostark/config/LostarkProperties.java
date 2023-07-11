package com.bboky.lostark.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "lostark")
@Data
public class LostarkProperties {
    private String baseurl;
    private String token;
}
