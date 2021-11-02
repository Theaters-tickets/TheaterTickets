package com.netcracker.theater.rtickets.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;


@Entity
@Data
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue
    @JsonIgnore
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Column
    private String image;

    @Column
    private String source_name;

    @Column
    private String source_link;

    public String getImage() {
        return image;
    }
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }


    @Column
    private int score;

    public Picture() {
    }

    public Picture(String image, int score) {
        this.image = image;
        this.score = score;
    }
    @JsonProperty("source")
    public  void setSource(Map<String,String> source) {
        source_name = source.get("name");
        source_link = source.get("link");
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", comment='" + image + '\'' +
                ", score=" + score +
                '}';
    }
}
