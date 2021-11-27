package com.netcracker.theater.rtickets.parser;


import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Play {
    private int id;
    private List<Dates> dates;
    private String title;
    private Integer place_id;
    private String description;
    private String body_text;
    private List<String> categories;
    private String age_restriction;
    private String price;
    private boolean is_free;
    private List<Image> images;
    private String short_title;
    private List<String> tags;
    private List<Participants> participants;



    //private int favorites_count;
    //private String site_url;
    //private int comments_count;
    //private boolean disable_comments;
    //private long publication_date;
    //private String tagline;
    //private Map<String, String> location;



    private String slug;



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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.replaceAll("<[^>]*>", "");
    }

    public List<Dates> getDates() {
        return dates;
    }

    public void setDates(List<Dates> dates) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isIs_free() {
        return is_free;
    }

    public void setIs_free(boolean is_free) {
        this.is_free = is_free;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer  getPlace() {
        return place_id;
    }

    public void setPlace(Map<String,Integer>  place) {
        try {
            this.place_id = place.get("id");
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String>  categories) {
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
                ", place_id='" + place_id + '\'' +
                ", price='" + price + '\'' +
                ", categories='" + categories + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }

}

