package com.scopely.integration.leanplum.model;

import com.google.common.collect.ImmutableSet;
import com.scopely.integration.leanplum.MinimalMap;

import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class SetUserAttributes extends MinimalMap implements LeanplumMultiplexable {

    Map<String, Object> userAttributes;
    Map<String, Object> userAttributeValuesToAdd;
    Map<String, Object> userAttributeValuesToRemove;
    String newUserId;
    // TODO still needs to support: events, and states

    public void setUserAttributes(Map<String, Object> userAttributes) {
        this.userAttributes = userAttributes;
    }

    public void setUserAttributeValuesToAdd(Map<String, Object> userAttributeValuesToAdd) {
        this.userAttributeValuesToAdd = userAttributeValuesToAdd;
    }

    public void setUserAttributeValuesToRemove(Map<String, Object> userAttributeValuesToRemove) {
        this.userAttributeValuesToRemove = userAttributeValuesToRemove;
    }

    public void setNewUserId(String newUserId) {
        this.newUserId = newUserId;
    }

    @Override
    public String action() {
        return "setUserAttributes";
    }

    @NotNull
    @Override
    public Set<Entry<String, Object>> entrySet() {
        //noinspection unchecked
        return ImmutableSet.of(
                new AbstractMap.SimpleImmutableEntry<>("userAttributes", userAttributes),
                new AbstractMap.SimpleImmutableEntry<>("userAttributeValuesToAdd", userAttributeValuesToAdd),
                new AbstractMap.SimpleImmutableEntry<>("userAttributeValuesToRemove", userAttributeValuesToRemove),
                new AbstractMap.SimpleImmutableEntry<>("newUserId", newUserId)
        );
    }
}
