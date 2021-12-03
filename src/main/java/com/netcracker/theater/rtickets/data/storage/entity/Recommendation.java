package com.netcracker.theater.rtickets.data.storage.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "recommendation")
public class Recommendation {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "ruName")
    private String ruName;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "recommendation_id")
    private Set<Category> categories;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    private Picture picture = new Picture("/img/default.jpg");

    public Recommendation() {}

    public Recommendation(String name, String ruName) {
        this.name = name;
        this.ruName = ruName;
    }


    public void addCategory(Category category)
    {
        if (categories == null) categories = new HashSet<>();
        categories.add(category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recommendation that = (Recommendation) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



}
