package com.scopely.integration.leanplum.model;

import com.scopely.integration.leanplum.MinimalMap;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Set;

public class GetVars extends MinimalMap implements LeanplumMultiplexable {
    private final Boolean includeDefaults;

    public GetVars(boolean includeDefaults) {
        this.includeDefaults = includeDefaults;
    }

    public GetVars() {
        includeDefaults = null;
    }

    @NotNull
    @Override
    public Set<Entry<String, Object>> entrySet() {
        return includeDefaults != null ?
                Collections.singleton(new AbstractMap.SimpleImmutableEntry<>("includeDefaults", includeDefaults))
                : Collections.EMPTY_SET;
    }

    @Override
    public String action() {
        return "getVars";
    }
}
