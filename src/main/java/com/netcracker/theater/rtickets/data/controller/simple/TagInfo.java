package com.netcracker.theater.rtickets.data.controller.simple;

import java.io.Serializable;

public class TagInfo implements Serializable {

    String parent;
    String tag;

    public TagInfo(){}

    public TagInfo(String parent, String tag){
        this.parent = parent;
        this.tag = tag;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString(){
        return this.parent + "/" + this.tag;
    }
}
