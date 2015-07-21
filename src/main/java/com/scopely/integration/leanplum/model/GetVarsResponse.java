package com.scopely.integration.leanplum.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.scopely.integration.leanplum.LeanplumActionResponse;

import java.util.List;
import java.util.Map;

public class GetVarsResponse extends LeanplumActionResponse {
    public JsonNode vars;
    /**
     * Datatype and purpose unknown
     */
    public List<JsonNode> interfaceRules;
    public List<JsonNode> variants;
    /**
     * Datatype and purpose unknown
     */
    public JsonNode regions;
    /**
     * The keys here are message IDs
     */
    public Map<String, JsonNode> messages;
    /**
     * Data type and purpose unknown.
     */
    public List<JsonNode> interfaceEvents;
}
