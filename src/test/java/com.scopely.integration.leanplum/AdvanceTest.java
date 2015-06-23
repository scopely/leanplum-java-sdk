package com.scopely.integration.leanplum;

import com.scopely.integration.leanplum.model.ActionParams;
import com.scopely.integration.leanplum.model.Advance;
import org.junit.Test;
import rx.observers.TestSubscriber;

import static org.fest.assertions.api.Assertions.assertThat;

public class AdvanceTest extends ProductionApiClientTest {

    /**
     * Contrary to the documentation, `state` is not required.
     */
    @Test
    public void testAdvance_succeedWithEmptyPayload() throws Exception {
        TestSubscriber<LeanplumActionResponse> subscriber = awaitAndTransform(leanplumApi.advance(new Advance(null, null, null)));
        Throwable throwable = subscriber.getOnErrorEvents().get(0);
        // We're not in a session, so this should fail
        assertThat(throwable).isInstanceOf(LeanplumException.class);
    }

    @Test
    public void testAdvance_succeedWithProperPayload() throws Exception {
        TestSubscriber<LeanplumActionResponse> subscriber = awaitAndTransform(leanplumApi.advance(new Advance("really_cool_state", "useful info", ActionParams.of("gender", "F"))));
        Throwable throwable = subscriber.getOnErrorEvents().get(0);
        // Not in a session, so this should fail
        assertThat(throwable).isInstanceOf(LeanplumException.class);
    }
}
