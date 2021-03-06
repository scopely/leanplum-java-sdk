package com.scopely.integration.leanplum;

import com.scopely.integration.leanplum.model.ActionParams;
import com.scopely.integration.leanplum.model.SendMessage;
import com.scopely.integration.leanplum.model.SendMessageResponse;
import org.junit.Ignore;
import org.junit.Test;
import rx.observers.TestSubscriber;

import static org.fest.assertions.api.Assertions.assertThat;

@Ignore("This requires a test account with actual devices to succeed")
public class SendMessageTest extends ProductionApiClientTest {
    @Test
    public void testSendMessage_noRecipient() throws Exception {
        TestSubscriber<LeanplumActionResponse> testSubscriber = send(new SendMessage(6033514340810752l));
        testSubscriber.assertNoErrors();
        assertThat(testSubscriber.getOnNextEvents()).hasSize(1);
        assertThat(testSubscriber.getOnNextEvents().get(0)).isInstanceOf(SendMessageResponse.class);
        SendMessageResponse response = (SendMessageResponse) testSubscriber.getOnNextEvents().get(0);
        // Recipient is not a match
        assertThat(response.messagesSent).isEqualTo(0);
    }

    @Test
    public void testSendMessage_realRecipient() throws Exception {
        TestSubscriber<LeanplumActionResponse> testSubscriber = awaitAndTransform(apiForDevice("d926b3ba-8e45-4545-a220-f449f1b24679").sendMessage(new SendMessage(6219785998696448l)));
        testSubscriber.assertNoErrors();
        assertThat(testSubscriber.getOnNextEvents()).hasSize(1);
        assertThat(testSubscriber.getOnNextEvents().get(0)).isInstanceOf(SendMessageResponse.class);
        SendMessageResponse response = (SendMessageResponse) testSubscriber.getOnNextEvents().get(0);
        // Recipient is a match
        assertThat(response.messagesSent).isEqualTo(1);
    }

    @Test
    public void testSendMessage_realRecipient_withParams() throws Exception {
        TestSubscriber<LeanplumActionResponse> testSubscriber = awaitAndTransform(apiForDevice("d926b3ba-8e45-4545-a220-f449f1b24679").sendMessage(new SendMessage(6219785998696448l,
                ActionParams.of("name", "Jane User", "numMessages", 2))));
        testSubscriber.assertNoErrors();
        assertThat(testSubscriber.getOnNextEvents()).hasSize(1);
        assertThat(testSubscriber.getOnNextEvents().get(0)).isInstanceOf(SendMessageResponse.class);
        SendMessageResponse response = (SendMessageResponse) testSubscriber.getOnNextEvents().get(0);
        // Recipient is a match
        assertThat(response.messagesSent).isEqualTo(1);
    }

    private TestSubscriber<LeanplumActionResponse> send(SendMessage sendMessage) {
        return awaitAndTransform(leanplumApi.sendMessage(sendMessage));
    }
}
