package com.netcracker.theater.rtickets.data.core;

import lombok.Data;

import java.io.Serializable;

@Data
public class TagInfo implements Serializable {

    String parent;
    String tag;

    //public TagInfo(){}

    public TagInfo(String parent, String tag){
        this.parent = parent;
        this.tag = tag;
    }

}
