package com.netcracker.theater.rtickets.parser;

import java.util.List;
import java.util.Map;

public class Theater {
    private int id;
    private String title;
    private String address;
    private String timetable;
    private String phone;
    private String description;
    private String body_text;
    private String foreign_url;
    private Map<String, Object> coords;
    private String subway;
    private List<Image> images;
    private String short_title;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBody_text() {
        return body_text;
    }

    public void setBody_text(String body_text) {
        this.body_text = body_text;
    }

    public String getForeign_url() {
        return foreign_url;
    }

    public void setForeign_url(String foreign_url) {
        this.foreign_url = foreign_url;
    }

    public Map<String, Object> getCoords() {
        return coords;
    }

    public void setCoords(Map<String, Object> coords) {
        this.coords = coords;
    }

    public String getSubway() {
        return subway;
    }

    public void setSubway(String subway) {
        this.subway = subway;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getShort_title() {
        return short_title;
    }

    public void setShort_title(String short_title) {
        this.short_title = short_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", phone=" + phone  + '\'' +
                '}';
    }


}