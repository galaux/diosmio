package net.alaux.diosmio.gwt.client;

import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("artifactService")
public interface ArtifactService extends RemoteService {

    Artifact addArtifact(Artifact artifact);

    Artifact getArtifact(Long id);

    Boolean deleteArtifact(Long id);

    Artifact updateArtifact(Artifact artifact);

}
