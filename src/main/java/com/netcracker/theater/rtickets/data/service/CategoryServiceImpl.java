package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.dao.CategoryDAO;
import com.netcracker.theater.rtickets.data.dao.GenreDAO;
import com.netcracker.theater.rtickets.data.entity.Category;
import com.netcracker.theater.rtickets.data.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryDAO.save(category);
    }

    @Override
    @Transactional
    public Category getCategory(UUID id) { return categoryDAO.findById(id).get(); }

    @Override
    @Transactional
    public void deleteCategory(UUID id) {
        categoryDAO.deleteById(id);
    }
}
