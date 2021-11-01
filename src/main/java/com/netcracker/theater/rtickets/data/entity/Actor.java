package com.netcracker.theater.rtickets.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    private String name;

    private String last_name;

    private String patronymic;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "performance_actor",
            joinColumns = { @JoinColumn(name = "actor_id") },
            inverseJoinColumns = { @JoinColumn(name = "performance_id") }
    )
    private Set<Performance> performances = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "actor_id")
    private Set<Picture> pictures = new HashSet<>();

    public Actor() {
    }

    public Actor(String name, String last_name, String patronymic) {
        this.name = name;
        this.last_name = last_name;
        this.patronymic = patronymic;
    }

    public Actor(String name, String last_name, String patronymic, Set<Performance> performances, Set<Picture> pictures) {
        this.name = name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.performances = performances;
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
