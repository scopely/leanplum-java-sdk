package com.scopely.integration.leanplum.model;

import com.google.common.collect.ImmutableSet;
import com.scopely.integration.leanplum.MinimalMap;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class Advance extends MinimalMap {
    String state;
    String info;
    ActionParams params;

    public Advance(String state, String info, ActionParams params) {
        this.state = state;
        this.info = info;
        this.params = params;
    }

    @NotNull
    @Override
    public Set<Map.Entry<String, Object>> entrySet() {
        //noinspection unchecked
        return ImmutableSet.of(
                new AbstractMap.SimpleImmutableEntry<>("state", state),
                new AbstractMap.SimpleImmutableEntry<>("info", info),
                new AbstractMap.SimpleImmutableEntry<>("params", params == null ? null : params.toString())
        );
    }
}
