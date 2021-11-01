package com.netcracker.theater.rtickets.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name ="theatre")
public class Theatre {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private int id;
    @Column(name = "long_name")
    private String title;
    @Column(name = "short_name")
    private String short_title;
    @Column(name = "address")
    private String address;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "phone")
    private String phone;
    @Column(name = "subway")
    private String subway;
    @Column(name = "timetable")
    private String timetable;
    @Column(name = "body_text", length = 10000)
    private String body_text;


    public Theatre() {
    }

    public Theatre(String name, String address) {
        this.short_title = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShort_title() {
        return short_title;
    }

    public void setShort_title(String short_title) {
        this.short_title = short_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.replaceAll("<[^>]*>", "");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubway() {
        return subway;
    }

    public void setSubway(String subway) {
        this.subway = subway;
    }

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    public String getBody_text() {
        return body_text;
    }

    public void setBody_text(String body_text) {
        this.body_text = body_text;
    }




    @Override
    public String toString() {
        return "Theatre{" +
                "id=" + id +
                ", name='" + short_title + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", subway='" + subway + '\'' +
                ", timetable='" + timetable + '\'' +
                '}';
    }
}
