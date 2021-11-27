package com.netcracker.theater.rtickets.parser;

public class Categories {
    private int id;
    private String slug;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
