package com.netcracker.theater.rtickets.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Data
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Column
    private String comment;

    @Column
    private int score;

    public Picture() {
    }

    public Picture(String comment, int score) {
        this.comment = comment;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", score=" + score +
                '}';
    }
}
