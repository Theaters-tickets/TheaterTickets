package com.netcracker.theater.rtickets.entity;

import javax.persistence.*;

@Entity
@Table (name="participants")
public class Participants {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private String title;
    private String role;
    private String agent_type;
    private String image;
    private String site_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAgent_type() {
        return agent_type;
    }

    public void setAgent_type(String agent_type) {
        this.agent_type = agent_type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSite_url() {
        return site_url;
    }

    public void setSite_url(String site_url) {
        this.site_url = site_url;
    }

}
