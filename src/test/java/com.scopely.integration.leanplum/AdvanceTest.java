package com.scopely.integration.leanplum;

import com.scopely.integration.leanplum.model.ActionParams;
import com.scopely.integration.leanplum.model.Advance;
import org.junit.Test;
import rx.observers.TestSubscriber;

public class AdvanceTest extends ProductionApiClientTest {

    /**
     * Contrary to the documentation, `state` is not required.
     */
    @Test
    public void testAdvance_succeedWithEmptyPayload() throws Exception {
        TestSubscriber<LeanplumActionResponse> subscriber = awaitAndTransform(leanplumApi.advance(new Advance(null, null, null)));
        subscriber.assertNoErrors();
    }

    @Test
    public void testAdvance_succeedWithProperPayload() throws Exception {
        TestSubscriber<LeanplumActionResponse> subscriber = awaitAndTransform(leanplumApi.advance(new Advance("really_cool_state", "useful info", ActionParams.of("gender", "F"))));
        subscriber.assertNoErrors();
    }
}
