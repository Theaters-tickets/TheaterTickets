package com.netcracker.theater.rtickets.data.storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/*

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;


    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "genres", fetch = FetchType.EAGER)
    private List<Repertoire> repertoires;




    public Genre(String name) {
        this.name = name;
    }

    public Genre(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre(String name, List<Repertoire> repertoires) {
        this.name = name;
        this.repertoires = repertoires;
    }

    public void addRepertoire(Repertoire repertoire)
    {
        if (repertoires == null) repertoires = new ArrayList<>();
        repertoires.add(repertoire);

    }


}

 */
