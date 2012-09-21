package net.alaux.diosmio.gwt.client.common;

import java.util.ArrayList;
import java.util.List;

import net.alaux.diosmio.gwt.shared.ArtifactDto;

public class ArtifactsColumnDefinitionsFactory<T> {

    public static List<ColumnDefinition<ArtifactDto>> getArtifactsListColumnDefinitions() {
	return ArtifactsListColumnDefinitionsImpl.getInstance();
    }

    public static List<ColumnDefinition<ArtifactDto>> getTestArtifactsListColumnDefinitions() {
	return new ArrayList<ColumnDefinition<ArtifactDto>>();
    }
}
