package com.scopely.integration.leanplum.model;

import com.scopely.integration.leanplum.LeanplumActionResponse;

public class SendMessageResponse extends LeanplumActionResponse {
    public String result;
    public int messagesSent;
}
