package com.netcracker.theater.rtickets.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "theatre")
public class Theatre {
    @Id
    @GeneratedValue
    @JsonIgnore
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Column(name = "name")
    @JsonProperty("title")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "description", length = 10000)
    private String description;

    @Column(name = "subway")
    private String subway;

    @Column(name = "phone")
    private String phone;

    @Column(name = "timetable")
    private String timetable;

    @Column(name = "title", length = 5000)
    private String title;

    @Column(name = "number")
    private String number;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "theatre_id")
    private Set<Performance> performances = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "theatre_id")
    private Set<Picture> pictures = new HashSet<>();

    public void addPerformance(Performance parameter)
    {
        if (performances == null) performances = new HashSet<>();
        performances.add(parameter);
    }

    public void addPicture(Picture picture)
    {
        if (pictures == null) pictures = new HashSet<>();
        pictures.add(picture);
    }


    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("title")
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }
    @JsonProperty("body_text")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubway() {
        return subway;
    }

    public void setSubway(String subway) {
        this.subway = subway;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("description")
    public void setTitle(String title) {
        this.title = title.replaceAll("<[^>]*>", "");
    }
    @JsonProperty("number")
    public String getNumber() {
        return number;
    }
    @JsonProperty("id")
    public void setNumber(String number) {
        this.number = number;
    }

    public Theatre() {
    }

    public Theatre(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Theatre(String name, String address, String description, String subway, String phone, String timetable, String title, String id) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.subway = subway;
        this.phone = phone;
        this.timetable = timetable;
        this.title = title;
        this.number = id;
    }

    public Theatre(String name, String address, String description, String subway, String phone, String timetable, String title, String number, Set<Performance> performances, Set<Picture> pictures) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.subway = subway;
        this.phone = phone;
        this.timetable = timetable;
        this.title = title;
        this.number = number;
        this.performances = performances;
        this.pictures = pictures;
    }




    @Override
    public String toString() {
        return "Theatre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", subway='" + subway + '\'' +
                ", phone='" + phone + '\'' +
                ", timetable='" + timetable + '\'' +
                ", title='" + title + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
