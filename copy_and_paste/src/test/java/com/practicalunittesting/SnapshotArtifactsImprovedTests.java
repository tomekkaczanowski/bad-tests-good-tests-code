package com.practicalunittesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SnapshotArtifactsImprovedTests {

    private static final String VALID_GROUP = "group";
    private static final String VALID_ARTIFACT_ID = "artifact_id";
    private static final Type VALID_TYPE = Type.JAR;

    @DataProvider
    public Object[][] snapshotVersions() {
        return new Object[][]{
                {"2.2-SNAPSHOT"},
                {"2.2.4.6-SNAPSHOT"},
                {"2-SNAPSHOT"}
        };
    }

    @Test(dataProvider = "snapshotVersions")
    public void shouldRecognizeSnapshots(String version) {
        Artifact artifact
                = new Artifact(VALID_GROUP, VALID_ARTIFACT_ID,
                version, VALID_TYPE);
        assertThat(artifact.isSnapshot()).isTrue();
    }
}
