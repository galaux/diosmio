package net.alaux.diosmio.gwt.server;

import java.util.ArrayList;
import java.util.List;

import net.alaux.diosmio.gwt.client.ArtifactService;
import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ArtifactServiceImpl extends RemoteServiceServlet implements
	ArtifactService {

    List<Artifact> artifacts;

    // private final Random random = new Random();

    public ArtifactServiceImpl() {
	artifacts = new ArrayList<Artifact>();
	artifacts.add(new Artifact(1L, "test.war"));
	artifacts.add(new Artifact(2L, "other.war"));
	artifacts.add(new Artifact(3L, "yetanother.war"));
	artifacts.add(new Artifact(4L, "again.war"));
	artifacts.add(new Artifact(5L, "again-2.0.war"));
    }

    @Override
    public Artifact addArtifact(Artifact artifact) {
	artifact.setId(new Double(Math.random() * 100 + 10).longValue());
	artifacts.add(artifact);
	return artifact;
    }

    @Override
    public Artifact getArtifact(Long id) {
	for (Artifact artifact : artifacts) {
	    if (artifact.getId().equals(id)) {
		return artifact;
	    }
	}
	// TODO use an Exception here
	return null;
    }

    @Override
    public Boolean deleteArtifact(Long id) {
	for (Artifact artifact : artifacts) {
	    if (artifact.getId().equals(id)) {
		artifacts.remove(artifact);
		return true;
	    }
	}
	return false;
    }

    @Override
    public Artifact updateArtifact(Artifact artifact) {
	for (Artifact a : artifacts) {
	    if (a.getId().equals(artifact.getId())) {
		a.setName(artifact.getName());
	    }
	}
	return artifact;
    }

    @Override
    public List<Long> deleteArtifacts(List<Long> ids) {
	List<Long> deletedIds = new ArrayList<Long>();
	List<Artifact> oldArtifactList = new ArrayList<Artifact>(artifacts);

	for (Artifact artifact : oldArtifactList) {
	    if (ids.contains(artifact.getId())) {
		artifacts.remove(artifact);
		deletedIds.add(artifact.getId());
	    }
	}

	return deletedIds;
    }

    @Override
    public List<Artifact> getAllArtifacts() {
	return new ArrayList<Artifact>(artifacts);
    }

}
