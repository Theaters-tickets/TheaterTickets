package com.netcracker.theater.rtickets.data.controller.simple;

import com.netcracker.theater.rtickets.data.entity.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupsContainer {

    HashMap<String, List<String>> mapContainer = new HashMap<>();

    public GroupsContainer(){}

    public HashMap<String, List<String>>  getMapContainer(){
        return mapContainer;
    }

    public GroupsContainer(List<Category> categories){
        for (Category cat : categories){
            String type = cat.getType();
            if (mapContainer.containsKey(type)){
                mapContainer.get(type).add(cat.getName());
            }
            else{
                List<String> newTag = new ArrayList<>();
                newTag.add(cat.getName());
                mapContainer.put(type, newTag);
            }
        }
    }

}
