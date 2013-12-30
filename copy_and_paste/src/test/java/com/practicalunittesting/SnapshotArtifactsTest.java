package com.practicalunittesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SnapshotArtifactsTest {

    @DataProvider
    public Object[][] snapshotArtifacts() {
        return new Object[][]{
                {"a", "b", "2.2-SNAPSHOT", Type.JAR },
                {"c", "d", "2.2.4.6-SNAPSHOT", Type.JAR},
                {"e", "f", "2-SNAPSHOT", Type.JAR}
        };
    }

    @Test(dataProvider = "snapshotArtifacts")
    public void shouldRecognizeSnapshots(
            String groupId, String artifactId,
            String version, Type type) {
        Artifact artifact
                = new Artifact(groupId, artifactId, version, type);
        assertThat(artifact.isSnapshot()).isTrue();
    }
}
