package com.scopely.integration.leanplum;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class MinimalMap implements Map<String, Object> {
    @Override
    public int size() {
        return entrySet().size();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object get(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object put(String key, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException();
    }

    @NotNull
    @Override
    public Collection<Object> values() {
        throw new UnsupportedOperationException();
    }

    /**
     * Appends fields to an existing open object. You are forewarned.
     */
    public static class MinimalMapAppendingSerializer extends JsonSerializer<MinimalMap> {
        @Override
        public void serialize(MinimalMap value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            Set<Map.Entry<String, Object>> entries = value.entrySet();

            for (Map.Entry<String, Object> entry : entries) {
                if (entry.getValue() == null) {
                    gen.writeNullField(entry.getKey());
                    continue;
                }

                if (Number.class.isAssignableFrom(entry.getValue().getClass())) {
                    // not sure about this
                    gen.writeNumberField(entry.getKey(), ((Number) entry.getValue()).doubleValue());
                    continue;
                }

                if (entry.getValue() instanceof Boolean) {
                    gen.writeBooleanField(entry.getKey(), (Boolean) entry.getValue());
                    continue;
                }

                gen.writeStringField(entry.getKey(), entry.getValue().toString());
            }

        }
    }

    public static final MinimalMapAppendingSerializer APPENDING_SERIALIZER = new MinimalMapAppendingSerializer();
}
