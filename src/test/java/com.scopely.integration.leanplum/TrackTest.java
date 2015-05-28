package com.scopely.integration.leanplum;

import com.scopely.integration.leanplum.model.ActionParams;
import com.scopely.integration.leanplum.model.Track;
import org.junit.Test;
import rx.observers.TestSubscriber;

import static org.fest.assertions.api.Assertions.assertThat;

public class TrackTest extends ProductionApiClientTest {
    @Test
    public void testTrack_FailsWithEmptyPayload() throws Exception {
        TestSubscriber<LeanplumActionResponse> testSubscriber = track(new Track(null, null, null, null, null, null, true));
        assertThat(testSubscriber.getOnErrorEvents()).hasSize(1);
        assertThat(testSubscriber.getOnErrorEvents().get(0)).isInstanceOf(LeanplumException.class);
        //noinspection ThrowableResultOfMethodCallIgnored
        assertThat(((LeanplumException) testSubscriber.getOnErrorEvents().get(0)).getResponse().error).isEqualsToByComparingFields(LeanplumError.createLeanplumError("'event' must be provided"));
    }

    @Test
    public void testTrack_SucceedsWithEventName() throws Exception {
        TestSubscriber<LeanplumActionResponse> testSubscriber = track(new Track("level_up", null, null, null, null, null, true));
        testSubscriber.assertNoErrors();
    }

    /**
     * This should not be accepted
     */
    @Test
    public void testTrack_SucceedsWithOnlyMessageId() throws Exception {
        TestSubscriber<LeanplumActionResponse> testSubscriber = track(new Track(null, null, null, null, null, 12, true));
        testSubscriber.assertNoErrors();
    }

    @Test
    public void testTrack_withParams() throws Exception {
        TestSubscriber<LeanplumActionResponse> testSubscriber = track(new Track(null, null, null, null, ActionParams.of("key", 12), 12, true));
        testSubscriber.assertNoErrors();
    }


    @Test
    public void testTrack_withName_andParams() throws Exception {
        TestSubscriber<LeanplumActionResponse> testSubscriber = track(new Track("my_event", null, null, null, ActionParams.of("key", 12), null, true));
        testSubscriber.assertNoErrors();
    }

    private TestSubscriber<LeanplumActionResponse> track(Track track) {
        return awaitAndTransform(leanplumApi.track(track));
    }

}
