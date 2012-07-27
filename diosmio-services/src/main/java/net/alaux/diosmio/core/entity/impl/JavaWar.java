package net.alaux.diosmio.core.entity.impl;

import me.prettyprint.hom.annotations.Column;
import me.prettyprint.hom.annotations.Id;
import net.alaux.diosmio.core.entity.Artifact;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/16/12
 * Time: 11:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="ColumnFamilyName")
public class JavaWar implements Artifact {

    @Id
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="relativePath")
    private String relativePath;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public JavaWar(String name, String relativePath) {
        this.name = name;
        this.relativePath = relativePath;
    }
}
