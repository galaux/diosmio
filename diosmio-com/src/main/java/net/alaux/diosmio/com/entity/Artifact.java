package net.alaux.diosmio.com.entity;

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
@Table(name = "ARTIFACT")
@NamedQueries({
	@NamedQuery(name = Artifact.Q_FIND_ALL, query = Artifact.Q_FIND_ALL),
	@NamedQuery(name = Artifact.Q_DELETE_BY_ID, query = Artifact.Q_DELETE_BY_ID) //
})
public class Artifact implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String Q_FIND_ALL = "SELECT a FROM Artifact a";
    public static final String Q_DELETE_BY_ID = "DELETE FROM Artifact a WHERE a.id = :id";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /*
     * The no-argument constructor, which is also a JavaBean convention, is a
     * requirement for all persistent classes
     */
    public Artifact() {
    }

    public Artifact(long id, String name) {
	this.id = id;
	this.name = name;
    }

    public Artifact(JSONObject jsonObject) {
	this.name = (String) jsonObject.get("name");
    }

    @Override
    public String toString() {
	return id + "\t" + name;
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
}