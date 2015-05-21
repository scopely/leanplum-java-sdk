package com.scopely.integration.leanplum.model;

import com.scopely.integration.leanplum.MinimalMap;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Set;

public class DownloadFile extends MinimalMap {
    private final String filename;

    public DownloadFile(String filename) {
        this.filename = filename;
    }

    @NotNull
    @Override
    public Set<Entry<String, Object>> entrySet() {
        return Collections.singleton(new AbstractMap.SimpleImmutableEntry<>("filename", filename));
    }

    @Override
    public String toString() {
        return "DownloadFile{" +
                "filename='" + filename + '\'' +
                '}';
    }
}
