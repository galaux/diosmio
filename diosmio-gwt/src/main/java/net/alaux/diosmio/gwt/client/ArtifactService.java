package net.alaux.diosmio.gwt.client;

import java.util.List;

import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("artifactService")
public interface ArtifactService extends RemoteService {

    Artifact addArtifact(Artifact artifact);

    Artifact getArtifact(Long id);

    List<Artifact> getAllArtifacts();

    Boolean deleteArtifact(Long id);

    List<Long> deleteArtifacts(List<Long> ids);

    Artifact updateArtifact(Artifact artifact);

}
