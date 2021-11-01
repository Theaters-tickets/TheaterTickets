package com.netcracker.theater.rtickets.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "repertoire")
public class Repertoire {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column(name="age_min")
    private int age_min;

    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "repertoire_genres",
            joinColumns = @JoinColumn(name = "repertoire_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "repertoire_id")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "repertoire_id")
    private Set<Performance> performances = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "category_id")
    private Set<Category> categories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "picture_id")
    private Set<Picture> pictures = new HashSet<>();

    public void addGenre(Genre genre)
    {
        if (genres == null) genres = new HashSet<>();
        genres.add(genre);
    }

    public void addComment(Comment comment)
    {
        if (comments == null) comments = new HashSet<>();
        comments.add(comment);
    }

    public void addPerformance(Performance performance)
    {
        if (performances == null) performances = new HashSet<>();
        performances.add(performance);
    }

    public void addToPictures (Picture picture)
    {
        if (pictures == null) pictures = new HashSet<>();
        pictures.add(picture);
    }

    public void addCategory(Category category)
    {
        if (categories == null) categories = new HashSet<>();
        categories.add(category);
    }

    public Repertoire() {
    }

    public Repertoire(String name, int age_min, String title) {
        this.name = name;
        this.age_min = age_min;
        this.title = title;
    }

    public Repertoire(String name, int age_min, String title, Set<Genre> genres, Set<Comment> comments, Set<Performance> performances, Set<Category> categories, Set<Picture> pictures) {
        this.name = name;
        this.age_min = age_min;
        this.title = title;
        this.genres = genres;
        this.comments = comments;
        this.performances = performances;
        this.categories = categories;
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "Repertoire{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age_min=" + age_min +
                ", title='" + title + '\'' +
                '}';
    }
}
