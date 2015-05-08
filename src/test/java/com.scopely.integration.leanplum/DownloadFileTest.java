package com.scopely.integration.leanplum;

import com.scopely.integration.leanplum.model.DownloadFile;
import org.junit.Test;
import retrofit.RetrofitError;
import rx.observers.TestSubscriber;

import java.util.UUID;

import static org.fest.assertions.api.Assertions.assertThat;

public class DownloadFileTest extends ProductionApiClientTest {
    @Test
    public void testDownloadFile_failIfMissing() throws Exception {
        TestSubscriber<LeanplumActionResponse> subscriber = awaitAndTransform(leanplumApi.downloadFile(new DownloadFile(UUID.randomUUID().toString())));
        assertThat(subscriber.getOnErrorEvents()).hasSize(1);
        assertThat(subscriber.getOnErrorEvents().get(0)).isInstanceOf(RetrofitError.class);
        assertThat(subscriber.getOnErrorEvents().get(0).getMessage()).isEqualTo("404 Not Found");
    }
}
