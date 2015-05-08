package com.scopely.integration.leanplum;

import retrofit.RequestInterceptor;

import java.util.concurrent.TimeUnit;

public class LeanplumInterceptor implements RequestInterceptor {
    private final String appId;
    private final String clientKey;
    private final String apiVersion = "1.0.6";
    private final boolean devMode;

    private final String userId;
    private final String deviceId;

    private final boolean multi;

    private LeanplumInterceptor(String appId, String clientKey, boolean devMode, boolean multi, String userId, String deviceId) {
        this.appId = appId;
        this.clientKey = clientKey;
        this.devMode = devMode;
        this.multi = multi;
        this.userId = userId;
        this.deviceId = deviceId;
    }

    public static LeanplumInterceptor createMultiInterceptor(String appId, String clientKey, boolean devMode) {
        return new LeanplumInterceptor(appId, clientKey, devMode, true, null, null);
    }

    public static LeanplumInterceptor createInterceptorWithDeviceId(String appId, String clientKey, boolean devMode, String deviceId) {
        return new LeanplumInterceptor(appId, clientKey, devMode, false, null, deviceId);
    }

    public static LeanplumInterceptor createInterceptorWithUserId(String appId, String clientKey, boolean devMode, String userId) {
        return new LeanplumInterceptor(appId, clientKey, devMode, false, userId, null);
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addEncodedQueryParam("appId", appId);
        request.addEncodedQueryParam("clientKey", clientKey);
        request.addEncodedQueryParam("devMode", Boolean.toString(devMode));
        request.addEncodedQueryParam("apiVersion", apiVersion);

        if (multi) {
            request.addEncodedQueryParam("time", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
        } else {
            if (userId != null) {
                request.addEncodedQueryParam("userId", userId);
            }
            if (deviceId != null) {
                request.addEncodedQueryParam("deviceId", deviceId);
            }
        }
    }
}
