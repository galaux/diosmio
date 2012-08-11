package net.alaux.diosmio.services.entity;

import org.hibernate.annotations.GenericGenerator;
import org.json.simple.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/26/12
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ARTIFACT")
public class Artifact implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private String name;

    private String relativePath;

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

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    /* The no-argument constructor, which is also a JavaBean convention,
    is a requirement for all persistent classes */
    public Artifact() {
    }

    public Artifact(String name, String relativePath) {
        this.name = name;
        this.relativePath = relativePath;
    }

    public Artifact(JSONObject jsonObject) {
        this.name = (String) jsonObject.get("name");
        this.relativePath = (String) jsonObject.get("relativePath");
    }

    public String toString() {
        return id + "\t" + name + "\t" + relativePath;
    }
}