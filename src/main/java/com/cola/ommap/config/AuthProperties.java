package com.cola.ommap.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "om-map.auth")
public class AuthProperties {
    private List<String> noAuthUrls;

    public List<String> getNoAuthUrls() {
        return noAuthUrls;
    }

    public void setNoAuthUrls(List<String> noAuthUrls) {
        this.noAuthUrls = noAuthUrls;
    }
}
