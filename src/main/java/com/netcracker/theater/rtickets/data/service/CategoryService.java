package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.entity.Actor;
import com.netcracker.theater.rtickets.data.entity.Category;

import java.util.List;
import java.util.UUID;

//Added by Ilya
public interface CategoryService {

    List<Category> getAllCategories();

    void saveCategory(Category category);

    void updateType(String name, String type);

    List<Category> getUncategorizedCategories();
}
