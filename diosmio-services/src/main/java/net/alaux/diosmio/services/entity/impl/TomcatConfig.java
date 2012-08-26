package net.alaux.diosmio.services.entity.impl;

import net.alaux.diosmio.services.entity.Configuration;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 * Date: 8/11/12
 */
@Entity
@Table(name = "TOMCAT_CONFIG")
public class TomcatConfig implements Configuration {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private HostConfig host;

    private File catalinaHome;

    /* The no-argument constructor, which is also a JavaBean convention,
    is a requirement for all persistent classes */
    public TomcatConfig() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HostConfig getHost() {
        return host;
    }

    public void setHost(HostConfig host) {
        this.host = host;
    }

    public File getCatalinaHome() {
        return catalinaHome;
    }

    public void setCatalinaHome(File catalinaHome) {
        this.catalinaHome = catalinaHome;
    }
}
