package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAllCategories();

    void saveCategory(Category category);

    Category getCategory(UUID id);

    void deleteCategory(UUID id);
}
