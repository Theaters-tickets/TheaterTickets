package com.netcracker.theater.rtickets.data.storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue
    @JsonIgnore
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    private String name;

    private String last_name;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "performance_actor",
            joinColumns = { @JoinColumn(name = "actor_id") },
            inverseJoinColumns = { @JoinColumn(name = "performance_id") }
    )
    private Set<Performance> performances = new HashSet<>();

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "actor_id")
    private Set<Picture> pictures = new HashSet<>();



    public Actor(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
    }

    public Actor(String name, String last_name, Set<Performance> performances, Set<Picture> pictures) {
        this.name = name;
        this.last_name = last_name;
        this.performances = performances;
        this.pictures = pictures;
    }

    @JsonProperty("title")
    public void setFullName(String fullName) {
        int idx = fullName.trim().lastIndexOf(' ');
        if (idx == -1)
            throw new IllegalArgumentException("Only a single name: " + fullName);
        name = fullName.substring(0, idx);
        last_name  = fullName.substring(idx + 1);
    }
    @JsonProperty("images")
    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name) && Objects.equals(last_name, actor.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, last_name);
    }


}
