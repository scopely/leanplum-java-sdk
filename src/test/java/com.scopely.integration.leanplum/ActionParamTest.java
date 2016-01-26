package com.scopely.integration.leanplum;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scopely.integration.leanplum.model.ActionParams;
import com.scopely.integration.leanplum.model.Track;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

import static org.fest.assertions.api.Assertions.assertThat;

public class ActionParamTest {
    ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }


    @Test
    public void testSerializeMap() throws Exception {
        Track track = new Track();
        track.setParams(ActionParams.of("key", 1));

        LeanplumRequestBatchEntry entry = new LeanplumRequestBatchEntry(Instant.now(), null, true, null, track);

        String json = objectMapper.writeValueAsString(entry);
        JsonNode node = objectMapper.readTree(json);

        assertThat(node.has("params")).isTrue();
        assertThat(node.get("params").has("key"));
        assertThat(node.get("params").get("key").asInt()).isEqualTo(1);
    }

}
