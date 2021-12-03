package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.Category;

import java.util.List;

//Added by Ilya
public interface CategoryService {

    List<Category> getAllCategories();

    void saveCategory(Category category);

    void updateType(String name, String type);

    Category getCategoryByName(String name);

    List<Category> getUncategorizedCategories();
}
