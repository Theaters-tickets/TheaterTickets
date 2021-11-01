package com.netcracker.theater.rtickets.data.entity;

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
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "metro")
    private String metro;

    @Column(name = "phone")
    private String phone;



    @Column(name = "timing")
    private String timing;

    @Column(name = "title")
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

    public Theatre() {
    }

    public Theatre(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Theatre(String name, String address, String description, String metro, String phone, String timing, String title, String number) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.metro = metro;
        this.phone = phone;
        this.timing = timing;
        this.title = title;
        this.number = number;
    }

    public Theatre(String name, String address, String description, String metro, String phone, String timing, String title, String number, Set<Performance> performances, Set<Picture> pictures) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.metro = metro;
        this.phone = phone;
        this.timing = timing;
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
                ", metro='" + metro + '\'' +
                ", phone='" + phone + '\'' +
                ", timing='" + timing + '\'' +
                ", title='" + title + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
