package com.netcracker.theater.rtickets.data.storage.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Column
    private String text;

    @Column
    private int score;

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();


    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Repertoire repertoire;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return createdAt.format(formatter);
    }



    public Comment() {
    }

    public Comment(String text, int score) {
        this.text = text;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", score=" + score +
                ", user=" + user +
                ", rep=" + repertoire +

                '}';
    }
}
