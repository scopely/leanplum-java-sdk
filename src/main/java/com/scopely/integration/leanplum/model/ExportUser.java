package com.scopely.integration.leanplum.model;

public class ExportUser implements LeanplumMultiplexable {
    @Override
    public String action() {
        return "exportUser";
    }
}
