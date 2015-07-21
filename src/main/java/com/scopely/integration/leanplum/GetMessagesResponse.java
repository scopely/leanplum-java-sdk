package com.scopely.integration.leanplum;

import com.scopely.integration.leanplum.model.LeanplumMessage;

import java.util.List;

public class GetMessagesResponse extends LeanplumActionResponse {
    private List<LeanplumMessage> messages;

    public List<LeanplumMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<LeanplumMessage> messages) {
        this.messages = messages;
    }
}
