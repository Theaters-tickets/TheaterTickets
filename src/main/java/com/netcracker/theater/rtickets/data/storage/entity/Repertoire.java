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
@Table(name = "repertoire")
public class Repertoire {
    @Id
    @GeneratedValue
    @JsonIgnore
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column(name="age_min")
    private String age_min;

    @Column(name = "title", length = 5000)
    private String title;

    @Lob
    @Column(name = "description", length = 100000)
    private String description;
/*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "repertoire_genres",
            joinColumns = @JoinColumn(name = "repertoire_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;
 */

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "repertoire_id")
    private Set<Comment> comments = new HashSet<>();

    @Builder.Default
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "repertoire_id")
    private Set<Performance> performances = new HashSet<>();

    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "repertoire_categories",
            joinColumns = @JoinColumn(name = "repertoire_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "repertoire_id")
    private Set<Picture> pictures = new HashSet<>();

    @Builder.Default
    @ManyToMany(mappedBy = "repertoire_attended", fetch = FetchType.LAZY)
    private Set<User> usersAttended = new HashSet<>();

    @Builder.Default
    @ManyToMany(mappedBy = "repertoire_planned", fetch = FetchType.LAZY)
    private Set<User> usersPlanned = new HashSet<>();

    public void addToUsersAttended (User user)
    {
        usersAttended.add(user);
    }
    public void addToUsersPlanned (User user)
    {
        usersPlanned.add(user);
    }
/*
    public void addGenre(Genre genre)
    {
        if (genres == null) genres = new HashSet<>();
        genres.add(genre);
    }
 */

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


    public String getName() {
        return name;
    }
    @JsonProperty("short_title")
    public void setName(String name) {
        this.name = name;
    }

    public String getAge_min() {
        return age_min;
    }
    @JsonProperty("age_restriction")
    public void setAge_min(String age_min) {
        this.age_min = age_min.replaceAll("\\+", "");
    }

    public String getTitle() {
        return title;
    }
    @JsonProperty("description")
    public void setTitle(String title) {
        this.title = title.replaceAll("<[^>]*>", "");
    }

    public String getDescription() {
        return description;
    }
    @JsonProperty("body_text")
    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }
    @JsonProperty("images")
    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repertoire that = (Repertoire) o;
        return Objects.equals(name, that.name) && Objects.equals(age_min, that.age_min) && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age_min, title, description);
    }



    public double getRating() {
        double sum = 0;
        if (comments.isEmpty()) {
            return 0;
        }
        for (Comment comm : comments) {
            sum += comm.getScore();
        }
        return Math.round(sum/comments.size()* 100.0) / 100.0;
    }
    @JsonIgnore
    public Picture getOnePicture() {
        if (!pictures.isEmpty()) {
            return pictures.iterator().next();
        } else {return null;}
    }

    public Repertoire(String name, String age_min, String title) {
        this.name = name;
        this.age_min = age_min;
        this.title = title;
    }

    public Repertoire(String name, String age_min, String title/*, Set<Genre> genres */, Set<Comment> comments, Set<Performance> performances, Set<Category> categories, Set<Picture> pictures) {
        this.name = name;
        this.age_min = age_min;
        this.title = title;
        //this.genres = genres;
        this.comments = comments;
        this.performances = performances;
        this.categories = categories;
        this.pictures = pictures;
    }


}
