package com.scopely.integration.leanplum;

import com.fasterxml.jackson.databind.JsonNode;
import com.scopely.integration.leanplum.model.GetVars;
import com.scopely.integration.leanplum.model.GetVarsResponse;
import org.junit.Test;
import rx.observers.TestSubscriber;

import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;

public class GetVarsTest extends ProductionApiClientTest {

    @Test
    public void testGetVars_includeDefaults_True() throws Exception {
        TestSubscriber<LeanplumActionResponse> subscriber =
                awaitAndTransform(leanplumApi.getVars(new GetVars(true)));
        assertForSubscriber(subscriber);
    }

    @Test
    public void testGetVars_includeDefaults_False() throws Exception {
        TestSubscriber<LeanplumActionResponse> subscriber =
                awaitAndTransform(leanplumApi.getVars(new GetVars(false)));
        assertForSubscriber(subscriber);
    }

    @Test
    public void testGetVars_includeDefaults_omitted() throws Exception {
        TestSubscriber<LeanplumActionResponse> subscriber =
                awaitAndTransform(leanplumApi.getVars(new GetVars()));
        assertForSubscriber(subscriber);
    }

    private void assertForSubscriber(TestSubscriber<LeanplumActionResponse> subscriber) throws Exception {
        subscriber.assertNoErrors();
        assertThat(subscriber.getOnNextEvents().get(0)).isInstanceOf(GetVarsResponse.class);
        Map<String, JsonNode> messages = ((GetVarsResponse) subscriber.getOnNextEvents().get(0)).messages;
        assertThat(messages).isNotEmpty();
    }
}
