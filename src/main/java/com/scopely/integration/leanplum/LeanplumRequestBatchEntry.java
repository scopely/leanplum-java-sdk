package com.scopely.integration.leanplum;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.scopely.integration.leanplum.model.LeanplumMultiplexable;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.time.Instant;

@JsonSerialize(using = LeanplumRequestBatchEntry.LeanplumBatchEntrySerializer.class)
public class LeanplumRequestBatchEntry {
    Instant time;
    @Nullable
    String deviceId;
    boolean devMode = false;
    @Nullable
    String userId;
    @Nullable
    String versionName;

    LeanplumMultiplexable request;

    public LeanplumRequestBatchEntry(Instant time, @Nullable String deviceId, boolean devMode, @Nullable String userId, @Nullable String versionName, LeanplumMultiplexable request) {
        this.time = time;
        this.deviceId = deviceId;
        this.devMode = devMode;
        this.userId = userId;
        this.versionName = versionName;
        this.request = request;
    }

    public static class LeanplumBatchEntrySerializer extends JsonSerializer<LeanplumRequestBatchEntry> {
        @Override
        public void serialize(LeanplumRequestBatchEntry value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("action", value.request.action());
            gen.writeNumberField("time", value.time.getEpochSecond());
            gen.writeBooleanField("devMode", value.devMode);

            if (value.deviceId != null) {
                gen.writeStringField("deviceId", value.deviceId);
            }
            if (value.userId != null) {
                gen.writeStringField("userId", value.userId);
            }
            if (value.versionName != null) {
                gen.writeStringField("versionName", value.versionName);
            }

            if (value.request instanceof MinimalMap) {
                MinimalMap.APPENDING_SERIALIZER.serialize((MinimalMap) value.request, gen, serializers);
            }

            gen.writeEndObject();
        }
    }

    public static final LeanplumBatchEntrySerializer SERIALIZER = new LeanplumBatchEntrySerializer();
}
