package com.fileflow.model;

import java.time.Instant;

public class SignedUrlResult {
    private String url;
    private Instant expiresAt;

    public SignedUrlResult(String url, Instant expiresAt) {
        this.url = url;
        this.expiresAt = expiresAt;
    }

    public String getUrl() {
        return url;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

}
