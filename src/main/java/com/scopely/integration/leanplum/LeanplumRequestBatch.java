package com.scopely.integration.leanplum;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

public class LeanplumRequestBatch {
    @JsonSerialize
    List<LeanplumRequestBatchEntry> data;

    public LeanplumRequestBatch(List<LeanplumRequestBatchEntry> batch) {
        this.data = batch;
    }

    @Override
    public String toString() {
        return "LeanplumRequestBatch{" +
                "data=" + data +
                '}';
    }
}
