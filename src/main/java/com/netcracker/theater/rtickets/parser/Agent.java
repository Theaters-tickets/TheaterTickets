package com.netcracker.theater.rtickets.parser;

import java.util.List;

public class Agent {
    private int id;
    private String title;
    private String slug;
    private String agent_type;
    private List<Image> images;
    private String site_url;
    private boolean is_stub;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getAgent_type() {
        return agent_type;
    }

    public void setAgent_type(String agent_type) {
        this.agent_type = agent_type;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getSite_url() {
        return site_url;
    }

    public void setSite_url(String site_url) {
        this.site_url = site_url;
    }

    public boolean isIs_stub() {
        return is_stub;
    }

    public void setIs_stub(boolean is_stub) {
        this.is_stub = is_stub;
    }


    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                '}';
    }
}
