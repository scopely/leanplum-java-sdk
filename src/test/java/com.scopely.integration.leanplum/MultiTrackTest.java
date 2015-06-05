package com.scopely.integration.leanplum;

import com.scopely.integration.leanplum.model.Track;
import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.time.Instant;
import java.util.Arrays;

import static org.fest.assertions.api.Assertions.assertThat;

public class MultiTrackTest extends ProductionApiClientTest {
    @Test
    public void testTrackTrackTrack() throws Exception {
        Observable<LeanplumResponse<LeanplumActionResponse>> multi = apiMulti().multi(Instant.now().getEpochSecond(),
                new LeanplumRequestBatch(
                        Arrays.asList(
                                new LeanplumRequestBatchEntry(Instant.now(), null, true, "me", null, new Track("event", null, null, null, null, null, true)),
                                new LeanplumRequestBatchEntry(Instant.now(), null, true, "me", null, new Track("event", null, null, null, null, null, true)),
                                new LeanplumRequestBatchEntry(Instant.now(), "234231", true, null, null, new Track("event", null, null, null, null, null, true))
                        )
                )
        );

        TestSubscriber<LeanplumActionResponse> subscriber = awaitAndTransform(multi);

        subscriber.assertNoErrors();
        assertThat(subscriber.getOnNextEvents()).hasSize(3);
    }
}
