package net.alaux.diosmio.gwt.client;

import java.util.List;

import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ArtifactServiceAsync {

    void addArtifact(Artifact artifact, AsyncCallback<Artifact> callback);

    void deleteArtifact(Long id, AsyncCallback<Boolean> callback);

    void deleteArtifacts(List<Long> ids, AsyncCallback<List<Long>> callback);

    void getAllArtifacts(AsyncCallback<List<Artifact>> callback);

    void getArtifact(Long id, AsyncCallback<Artifact> callback);

    void updateArtifact(Artifact artifact, AsyncCallback<Artifact> callback);

}
