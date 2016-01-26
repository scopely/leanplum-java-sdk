package com.scopely.integration.leanplum;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Set;

import static org.fest.assertions.api.Assertions.assertThat;

public class MinimalMapTest {
    @Test
    public void testSerializeMap() throws Exception {
        MinimalMap map = new MinimalMap() {
            @NotNull
            @Override
            public Set<Entry<String, Object>> entrySet() {
                return ImmutableMap.of("key", (Object) ImmutableMap.of("1", 2)).entrySet();
            }
        };

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(map);

        JsonNode node = objectMapper.readTree(json);

        assertThat(node.has("key")).isTrue();
        assertThat(node.get("key").get("1").asInt()).isEqualTo(2);
    }

    @Test
    public void testCanSerializeArray() throws Exception {
        MinimalMap map = new MinimalMap() {
            @NotNull
            @Override
            public Set<Entry<String, Object>> entrySet() {
                return ImmutableMap.of("key", (Object) new int[]{1, 2}).entrySet();
            }
        };

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(map);

        JsonNode node = objectMapper.readTree(json);

        assertThat(node.has("key")).isTrue();
        assertThat(node.get("key").get(0).asInt()).isEqualTo(1);
        assertThat(node.get("key").get(1).asInt()).isEqualTo(2);

    }
}
