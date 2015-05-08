package com.scopely.integration.leanplum;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;
import rx.Observable;
import rx.observers.TestSubscriber;

public class ProductionApiClientTest {
    LeanplumApi leanplumApi;

    @Before
    public void setUp() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String appId = System.getenv("LEANPLUM_APP_ID");
        String key = System.getenv("LEANPLUM_KEY");

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://www.leanplum.com")
                .setRequestInterceptor(
                        LeanplumInterceptor.createInterceptorWithUserId(appId, key, false, "avram@scopely.com"))
                .setConverter(new JacksonConverter(objectMapper))
                .build();

        leanplumApi = restAdapter.create(LeanplumApi.class);
    }

    protected TestSubscriber<LeanplumActionResponse> awaitAndTransform(Observable<LeanplumResponse> observable) {
        TestSubscriber<LeanplumActionResponse> testSubscriber = new TestSubscriber<>();

        observable
                .flatMap(response -> Observable.from(response.response))
                .lift(new LeanplumActionResponseErrorTransformOperator())
                .subscribe(testSubscriber);

        testSubscriber.awaitTerminalEvent();
        return testSubscriber;
    }
}
