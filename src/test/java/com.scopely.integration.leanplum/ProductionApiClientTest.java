package com.scopely.integration.leanplum;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;

import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;
import rx.Observable;
import rx.observers.TestSubscriber;

public class ProductionApiClientTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    LeanplumApi leanplumApi;
    private String appId;
    private String key;

    @Before
    public void setUp() throws Exception {
        appId = System.getenv("LEANPLUM_APP_ID");
        key = System.getenv("LEANPLUM_KEY");

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://www.leanplum.com")
                .setRequestInterceptor(
                        LeanplumInterceptor.createInterceptorWithUserId(appId, key, true, "avram@scopely.com"))
                .setConverter(new JacksonConverter(objectMapper))
                .build();

        leanplumApi = restAdapter.create(LeanplumApi.class);
    }

    protected LeanplumApi apiForDevice(String deviceId) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://www.leanplum.com")
                .setRequestInterceptor(
                        LeanplumInterceptor.createInterceptorWithDeviceId(appId, key, true, deviceId))
                .setConverter(new JacksonConverter(objectMapper))
                .build();

        return restAdapter.create(LeanplumApi.class);
    }

    protected LeanplumApi apiMulti() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://www.leanplum.com")
                .setRequestInterceptor(
                        LeanplumInterceptor.createMultiInterceptor(appId, key, true))
                .setConverter(new JacksonConverter(objectMapper))
                .build();

        return restAdapter.create(LeanplumApi.class);
    }

    protected <T extends LeanplumActionResponse> TestSubscriber<LeanplumActionResponse> awaitAndTransform(Observable<LeanplumResponse<T>> observable) {
        TestSubscriber<LeanplumActionResponse> testSubscriber = new TestSubscriber<>();

        observable
                .flatMap(response -> Observable.from(response.response))
                .lift(new LeanplumActionResponseErrorTransformOperator())
                .subscribe(testSubscriber);

        testSubscriber.awaitTerminalEvent();
        return testSubscriber;
    }
}
