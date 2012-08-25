package net.alaux.diosmio.services.entity;

import org.hibernate.annotations.GenericGenerator;
import org.json.simple.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User: miguel
 * Date: 7/26/12
 */
@Entity
@Table(name = "ARTIFACT")
public class Artifact implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private String name;

    // Not used anymore
    // TODO Get rid of this property
    private String fsName;

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

    /* The no-argument constructor, which is also a JavaBean convention,
    is a requirement for all persistent classes */
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

    public String toString() {
        return id + "\t" + name + "\t" + fsName;
    }
}