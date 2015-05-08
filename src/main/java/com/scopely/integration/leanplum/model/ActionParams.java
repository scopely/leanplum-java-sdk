package com.scopely.integration.leanplum.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public class ActionParams extends HashMap<String, Object> {
    private static final ObjectMapper mapper = new ObjectMapper();

    public ActionParams(Map<? extends String, ?> m) {
        super(m);
    }

    @Override
    public String toString() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    public static ActionParams of(String k, Object v) {
        return new ActionParams(ImmutableMap.of(k, v));
    }


    public static ActionParams of(String k, Object v, String k2, Object v2) {
        return new ActionParams(ImmutableMap.of(k, v, k2, v2));
    }


    public static ActionParams of(String k, Object v, String k2, Object v2, String k3, Object v3) {
        return new ActionParams(ImmutableMap.of(k, v, k2, v2, k3, v3));
    }
}
