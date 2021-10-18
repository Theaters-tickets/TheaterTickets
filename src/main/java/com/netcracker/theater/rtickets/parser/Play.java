package com.netcracker.theater.rtickets.parser;

import java.util.List;
import java.util.Map;

public class Play {



    private List<Image> images;
    private String body_text;
    private int favorites_count;
    private String description;
    private List<Map<String, Integer>> dates;
    private String title;
    private List<String> tags;
    private String short_title;
    private String site_url;
    private String price;
    private int comments_count;
    private boolean is_free;
    private boolean disable_comments;
    private long publication_date;
    private String tagline;
    private Map<String, String> location;
    private int id;
    private Map<String, Object> place;
    private List<String> categories;
    private String age_restriction;
    private String slug;
    private List<Participants> participants;


    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getBody_text() {
        return body_text;
    }

    public void setBody_text(String body_text) {
        this.body_text = body_text;
    }

    public int getFavorites_count() {
        return favorites_count;
    }

    public void setFavorites_count(int favorites_count) {
        this.favorites_count = favorites_count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Map<String, Integer>> getDates() {
        return dates;
    }

    public void setDates(List<Map<String, Integer>> dates) {
        this.dates = dates;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getShort_title() {
        return short_title;
    }

    public void setShort_title(String short_title) {
        this.short_title = short_title;
    }

    public String getSite_url() {
        return site_url;
    }

    public void setSite_url(String site_url) {
        this.site_url = site_url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public boolean isIs_free() {
        return is_free;
    }

    public void setIs_free(boolean is_free) {
        this.is_free = is_free;
    }

    public boolean isDisable_comments() {
        return disable_comments;
    }

    public void setDisable_comments(boolean disable_comments) {
        this.disable_comments = disable_comments;
    }

    public long getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(long publication_date) {
        this.publication_date = publication_date;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Map<String, String> getLocation() {
        return location;
    }

    public void setLocation(Map<String, String> location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getPlace() {
        return place;
    }

    public void setPlace(Map<String, Object> place) {
        this.place = place;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getAge_restriction() {
        return age_restriction;
    }

    public void setAge_restriction(String age_restriction) {
        this.age_restriction = age_restriction;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<Participants> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participants> participants) {
        this.participants = participants;
    }


    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description=" + description +
                ", price='" + price + '\'' +
                '}';
    }

}

