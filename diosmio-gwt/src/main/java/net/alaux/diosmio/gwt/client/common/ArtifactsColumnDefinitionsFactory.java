package net.alaux.diosmio.gwt.client.common;

import java.util.ArrayList;
import java.util.List;

import net.alaux.diosmio.gwt.shared.Artifact;

public class ArtifactsColumnDefinitionsFactory<T> {

    public static List<ColumnDefinition<Artifact>> getArtifactsListColumnDefinitions() {
	return ArtifactsListColumnDefinitionsImpl.getInstance();
    }

    public static List<ColumnDefinition<Artifact>> getTestArtifactsListColumnDefinitions() {
	return new ArrayList<ColumnDefinition<Artifact>>();
    }
}
