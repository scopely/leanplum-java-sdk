package com.scopely.integration.leanplum.model;

import com.google.common.collect.ImmutableSet;
import com.scopely.integration.leanplum.MinimalMap;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class SendMessage extends MinimalMap implements LeanplumMultiplexable {
    final long messageId;
    final boolean force;
    ActionParams values;

    public SendMessage(long messageId) {
        this.messageId = messageId;
        this.force = false;
    }

    public SendMessage(long messageId, boolean force, ActionParams values) {
        this.messageId = messageId;
        this.force = force;
        this.values = values;
    }

    public SendMessage(long messageId, ActionParams values) {
        this.messageId = messageId;
        this.values = values;
        this.force = false;
    }

    public long getMessageId() {
        return messageId;
    }

    public boolean isForce() {
        return force;
    }

    public ActionParams getValues() {
        return values;
    }

    @Override
    public String action() {
        return "sendMessage";
    }

    @NotNull
    @Override
    public Set<Map.Entry<String, Object>> entrySet() {
        //noinspection unchecked
        return ImmutableSet.of(
                new AbstractMap.SimpleImmutableEntry<>("messageId", messageId),
                new AbstractMap.SimpleImmutableEntry<>("force", force),
                new AbstractMap.SimpleImmutableEntry<>("values", values)
        );
    }
}
