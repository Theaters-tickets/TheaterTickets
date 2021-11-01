package com.netcracker.theater.rtickets.entity;

import com.netcracker.theater.rtickets.parser.Image;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="play")
public class Play {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Theatre theatre;
    private int repertoireId;
    private long startTime;
    private long endTime;
    private String images;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ActorsGroup",
            joinColumns = {@JoinColumn(name = "play_id")},
            inverseJoinColumns ={@JoinColumn(name = "participant_id")})
    private List<Participants> participants;


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

    public Theatre getTheatreId() {
        return theatre;
    }

    public void setTheatreId(Theatre theatre) {
        this.theatre = theatre;
    }

    public int getRepertoireId() {
        return repertoireId;
    }

    public void setRepertoireId(int repertoireId) {
        this.repertoireId = repertoireId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public List<Participants> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participants> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Play{" +
                "id=" + id +
                ", startTime='" + Instant.ofEpochSecond(startTime) + '\'' +
                ", endTime='" + Instant.ofEpochSecond(endTime) + '\'' +
                '}';
    }

}
