package com.netcracker.theater.rtickets.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "performance")
public class Performance {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    private Date timeStart;

    private Date timeEnd;

    private Date date;


    @ManyToMany(mappedBy = "performances")
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany(mappedBy = "performances_attended")
    private Set<User> usersAttended = new HashSet<>();

    @ManyToMany(mappedBy = "performances_planned")
    private Set<User> usersPlanned = new HashSet<>();



    public void addToUsersAttended (User user)
    {
        usersAttended.add(user);
    }
    public void addToUsersPlanned (User user)
    {
        usersPlanned.add(user);
    }

    public Performance() {
    }

    public Performance(Date timeStart, Date timeEnd, Date date) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.date = date;
    }

    public Performance(Date timeStart, Date timeEnd, Date date, Set<Actor> actors, Set<User> usersAttended, Set<User> usersPlanned) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.date = date;
        this.actors = actors;
        this.usersAttended = usersAttended;
        this.usersPlanned = usersPlanned;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "id=" + id +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", date=" + date +
                '}';
    }
}
