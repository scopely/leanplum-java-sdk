package com.scopely.integration.leanplum;

import java.util.List;

public class LeanplumResponse<T extends LeanplumActionResponse> {
    public List<T> response;

    @Override
    public String toString() {
        return "LeanplumResponse{" +
                "response=" + response +
                '}';
    }
}
