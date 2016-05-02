package com.scopely.integration.leanplum;

import java.util.Map;

public class LeanplumActionResponse {
    public boolean success;
    public boolean isOffline;
    public LeanplumError error;
    public LeanplumWarning warning;
    public Map<String, Object> userAttributes;

    @Override
    public String toString() {
        return "LeanplumActionResponse{" +
                "success=" + success +
                ", isOffline=" + isOffline +
                ", error=" + error +
                ", warning=" + warning +
                ", userAttributes=" + userAttributes +
                '}';
    }
}
