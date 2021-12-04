package com.netcracker.theater.rtickets.data.storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "role_actor")
public class RoleActor {
    @Id
    @GeneratedValue
    @JsonIgnore
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;
    private String name;

    @Builder.Default
    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name = "role_id")
    private Set<Actor> actors=new HashSet<>();

    public void addActor(Actor actor)
    {
        if (actors == null) actors = new HashSet<>();
        actors.add(actor);
    }

    public String getName() {
        return name;
    }
    @JsonProperty("slug")
    public void setName(String name) {
        this.name = name;
    }


    public RoleActor(String name) {
        this.name = name;
    }

    public RoleActor(String name, Set<Actor> actors) {
        this.name = name;
        this.actors = actors;
    }


}
