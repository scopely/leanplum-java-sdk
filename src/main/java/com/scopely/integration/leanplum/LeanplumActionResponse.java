package com.scopely.integration.leanplum;

public class LeanplumActionResponse {
    public boolean success;
    public boolean isOffline;
    public LeanplumError error;
    public LeanplumWarning warning;

    @Override
    public String toString() {
        return "LeanplumActionResponse{" +
                "success=" + success +
                ", isOffline=" + isOffline +
                ", error=" + error +
                ", warning=" + warning +
                '}';
    }
}
