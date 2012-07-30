package net.alaux.diosmio.core.entity.impl;

import org.hibernate.annotations.GenericGenerator;
import java.util.Date;
import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/30/12
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table( name = "EVENTS" )
public class Event {

    private Long id;

    private String title;
    private Date date;

    public Event() {
        // this form used by Hibernate
    }

    public Event(String title, Date date) {
        // for application use, to create new events
        this.title = title;
        this.date = date;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EVENT_DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
