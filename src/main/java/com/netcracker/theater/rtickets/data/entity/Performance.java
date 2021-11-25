package com.netcracker.theater.rtickets.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Entity
@Data
@Table(name = "performance")
public class Performance {
    @Id
    @JsonIgnore
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    private String timeStart;

    private String timeEnd;

    private String date;

    @ManyToMany(mappedBy = "performances")
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany(mappedBy = "performances_attended")
    private Set<User> usersAttended = new HashSet<>();

    @ManyToMany(mappedBy = "performances_planned")
    private Set<User> usersPlanned = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Repertoire repertoire;

    @ManyToOne(fetch = FetchType.LAZY)
    private Theatre theatre;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "attended_event",
            joinColumns = { @JoinColumn(name = "performance_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<User> users = new HashSet<>();


    @Transient
    SimpleDateFormat patternDate = new SimpleDateFormat("dd.MM.yyyy");
    @Transient
    SimpleDateFormat patternTime = new SimpleDateFormat("HH:mm:ss");

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

    public Performance(String timeStart, String timeEnd, String date) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.date = date;
    }

    public Performance(String timeStart, String timeEnd, String date, Set<Actor> actors, Set<User> usersAttended, Set<User> usersPlanned) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.date = date;
        this.actors = actors;
        this.usersAttended = usersAttended;
        this.usersPlanned = usersPlanned;
    }

    public String getTimeStart() {
        return timeStart;
    }
    @JsonProperty("start")
    public void setTimeStart(Long start) {
        this.timeStart = patternTime.format(Date.from(Instant.ofEpochSecond(start)));
        this.date = patternDate.format(Date.from(Instant.ofEpochSecond(start)));
    }

    public String getTimeEnd() {
        return timeEnd;
    }
    @JsonProperty("end")
    public void setTimeEnd(Long end) {
        this.timeEnd = patternTime.format(Date.from(Instant.ofEpochSecond(end)));
    }

    @JsonProperty("dates")
    public void setString(Map<String,Long> dates) {
        this.timeStart = patternTime.format(Date.from(Instant.ofEpochSecond(dates.get("start"))));
        this.date = patternDate.format(Date.from(Instant.ofEpochSecond(dates.get("start"))));
        this.timeEnd = patternTime.format(Date.from(Instant.ofEpochSecond(dates.get("end"))));
    }

    public Set<Actor> getActors() {
        return actors;
    }
    @JsonProperty("participants")
    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Performance that = (Performance) o;
        return Objects.equals(timeStart, that.timeStart) && Objects.equals(timeEnd, that.timeEnd) && Objects.equals(date, that.date) && Objects.equals(actors, that.actors) && Objects.equals(usersAttended, that.usersAttended) && Objects.equals(usersPlanned, that.usersPlanned) && Objects.equals(patternDate, that.patternDate) && Objects.equals(patternTime, that.patternTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStart, timeEnd, date, actors, usersAttended, usersPlanned, patternDate, patternTime);
    }

    @Override
    public String toString() {
        return "Performance{" +
                "id=" + id +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                '}';
    }
}
