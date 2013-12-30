package com.practicalunittesting;

public class Artifact {
    private final String groupId;
    private final String artifactId;
    private final String version;
    private final Type type;

    public Artifact(String groupId, String artifactId, String version, Type type) {

        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.type = type;
    }

    public boolean isSnapshot() {
        return version.endsWith("SNAPSHOT");
    }
}
