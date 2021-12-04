package com.netcracker.theater.rtickets.data.storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Builder.Default
    @ManyToMany(mappedBy = "performances", fetch = FetchType.LAZY)
    private Set<Actor> actors = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    private Repertoire repertoire;

    @ManyToOne(fetch = FetchType.LAZY)
    private Theatre theatre;

    @Transient
    SimpleDateFormat patternDate = new SimpleDateFormat("dd.MM.yyyy");
    @Transient
    SimpleDateFormat patternTime = new SimpleDateFormat("HH:mm:ss");



    public Performance(String timeStart, String timeEnd, String date) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.date = date;
    }

    public Performance(String timeStart, String timeEnd, String date, Set<Actor> actors) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.date = date;
        this.actors = actors;
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
        return Objects.equals(timeStart, that.timeStart) && Objects.equals(timeEnd, that.timeEnd) && Objects.equals(date, that.date) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStart, timeEnd, date, patternDate, patternTime);
    }


}
