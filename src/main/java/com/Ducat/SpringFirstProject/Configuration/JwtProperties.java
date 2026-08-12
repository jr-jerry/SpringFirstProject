package com.Ducat.SpringFirstProject.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jwt")
public class JwtProperties {
    private String secretKey;
    private int timeout;
    private int refreshTimeout;
    public String getSecretKey() {
        return secretKey;
    }
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
    public int getTimeout() {
        return timeout;
    }
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    public int getRefreshTimeout() {
        return refreshTimeout;
    }
    public void setRefreshTimeout(int refreshTimeout) {
        this.refreshTimeout = refreshTimeout;
    }
}
