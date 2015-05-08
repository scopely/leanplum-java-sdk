package com.scopely.integration.leanplum.model;

import com.google.common.collect.ImmutableSet;
import com.scopely.integration.leanplum.MinimalMap;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.Set;

public class Track extends MinimalMap implements LeanplumMultiplexable {
    String event;
    Float value;
    String currencyCode;
    String info;
    ActionParams params;
    Integer messageId;
    boolean allowOffline;

    public Track(String event,
                 Float value,
                 String currencyCode,
                 String info,
                 ActionParams params,
                 Integer messageId,
                 boolean allowOffline) {
        this.event = event;
        this.value = value;
        this.currencyCode = currencyCode;
        this.info = info;
        this.params = params;
        this.messageId = messageId;
        this.allowOffline = allowOffline;
    }

    @NotNull
    @Override
    public Set<Entry<String, Object>> entrySet() {
        //noinspection unchecked
        return ImmutableSet.of(
                new AbstractMap.SimpleImmutableEntry<>("event", event),
                new AbstractMap.SimpleImmutableEntry<>("value", value),
                new AbstractMap.SimpleImmutableEntry<>("currencyCode", currencyCode),
                new AbstractMap.SimpleImmutableEntry<>("info", info),
                new AbstractMap.SimpleImmutableEntry<>("params", params == null ? null : params.toString()),
                new AbstractMap.SimpleImmutableEntry<>("messageId", messageId),
                new AbstractMap.SimpleImmutableEntry<>("allowOffline", allowOffline)
                );
    }

    @Override
    public String action() {
        return "track";
    }
}
