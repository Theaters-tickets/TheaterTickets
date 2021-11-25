package com.netcracker.theater.rtickets.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<Repertoire> repertoires = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Recommendation recommendation;

    @Column
    private String name;

    //Added by Ilya
    @Column(columnDefinition = "varchar(255) default 'Uncategorized'")
    String type;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    public String getType(){return type;}

    public  void setType(String type){
        this.type = type;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
