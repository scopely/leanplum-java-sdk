package com.scopely.integration.leanplum;

import java.util.List;

public class LeanplumResponse {
    public List<LeanplumActionResponse> response;

    @Override
    public String toString() {
        return "LeanplumResponse{" +
                "response=" + response +
                '}';
    }
}
