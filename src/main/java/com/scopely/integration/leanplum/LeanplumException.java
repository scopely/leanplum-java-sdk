package com.scopely.integration.leanplum;

public class LeanplumException extends Exception {
    private final LeanplumActionResponse response;

    public LeanplumException(LeanplumActionResponse response) {
        this.response = response;
    }

    public LeanplumActionResponse getResponse() {
        return response;
    }
}
