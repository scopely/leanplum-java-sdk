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
    Long messageId;
    boolean allowOffline;

    public Track() {
    }

    public Track(String event,
                 Float value,
                 String currencyCode,
                 String info,
                 ActionParams params,
                 Long messageId,
                 boolean allowOffline) {
        this.event = event;
        this.value = value;
        this.currencyCode = currencyCode;
        this.info = info;
        this.params = params;
        this.messageId = messageId;
        this.allowOffline = allowOffline;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setParams(ActionParams params) {
        this.params = params;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public void setAllowOffline(boolean allowOffline) {
        this.allowOffline = allowOffline;
    }

    public String getEvent() {
        return event;
    }

    public Float getValue() {
        return value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getInfo() {
        return info;
    }

    public ActionParams getParams() {
        return params;
    }

    public Long getMessageId() {
        return messageId;
    }

    public boolean isAllowOffline() {
        return allowOffline;
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
                new AbstractMap.SimpleImmutableEntry<>("params", params == null ? null : params),
                new AbstractMap.SimpleImmutableEntry<>("messageId", messageId),
                new AbstractMap.SimpleImmutableEntry<>("allowOffline", allowOffline)
                );
    }

    @Override
    public String action() {
        return "track";
    }

    @Override
    public String toString() {
        return "Track{" +
                "event='" + event + '\'' +
                ", value=" + value +
                ", currencyCode='" + currencyCode + '\'' +
                ", info='" + info + '\'' +
                ", params=" + params +
                ", messageId=" + messageId +
                ", allowOffline=" + allowOffline +
                '}';
    }
}
