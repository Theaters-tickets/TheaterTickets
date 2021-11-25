package com.netcracker.theater.rtickets.parser;

public class Source {
    private String name;
    private String link;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                "link='" + link + '\'' +
                '}';
    }



}
