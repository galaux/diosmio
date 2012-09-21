package net.alaux.diosmio.services.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.json.simple.JSONObject;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net> Date: 7/26/12
 */
@Entity
@Table(name = Artifact.TABLE_NAME)
@NamedQueries({
	@NamedQuery(name = "artifact.findAll", query = "SELECT a FROM Artifact a"),
	@NamedQuery(name = "artifact.findByLogin", query = "SELECT a FROM Artifact a WHERE a.id = :id"),
	@NamedQuery(name = "artifact.deleteById", query = "DELETE FROM Artifact a WHERE a.id = :id") //
})
public class Artifact implements Serializable {

    public static final String TABLE_NAME = "ARTIFACT";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // Not used anymore
    // TODO Get rid of this property
    private String fsName;

    /*
     * The no-argument constructor, which is also a JavaBean convention, is a
     * requirement for all persistent classes
     */
    public Artifact() {
    }

    public Artifact(String name, String fsName) {
	this.name = name;
	this.fsName = fsName;
    }

    public Artifact(JSONObject jsonObject) {
	this.name = (String) jsonObject.get("name");
	this.fsName = (String) jsonObject.get("fsName");
    }

    @Override
    public String toString() {
	return id + "\t" + name + "\t" + fsName;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getFsName() {
	return fsName;
    }

    public void setFsName(String fsName) {
	this.fsName = fsName;
    }
}