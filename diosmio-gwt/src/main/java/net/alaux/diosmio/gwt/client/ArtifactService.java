package net.alaux.diosmio.gwt.client;

import java.util.List;

import net.alaux.diosmio.gwt.shared.ArtifactDto;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("artifactService")
public interface ArtifactService extends RemoteService {

    ArtifactDto addArtifact(ArtifactDto artifact);

    ArtifactDto getArtifact(Long id);

    List<ArtifactDto> getAllArtifacts();

    void deleteArtifact(Long id);

    List<Long> deleteArtifacts(List<Long> ids);

    ArtifactDto updateArtifact(ArtifactDto artifact);

}
