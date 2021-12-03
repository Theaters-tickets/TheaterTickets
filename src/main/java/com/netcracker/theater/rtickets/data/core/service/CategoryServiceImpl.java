package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.repository.CategoryDAO;
import com.netcracker.theater.rtickets.data.storage.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


//Added by Ilya
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Category> getAllCategories() { return categoryDAO.findAll();}

    @Override
    @Transactional
    public void saveCategory(Category category) {categoryDAO.save(category);}


    @Override
    @Transactional
    public void updateType(String name, String type){
        List<Category> toUpdate = categoryDAO.getCategoryWithName(name);
        type = type.equals("") ? "Uncategorized" : type;
        for (Category category : toUpdate){
            category.setType(type);
        }
    }

    @Override
    @Transactional
    public Category getCategoryByName(String name) { return categoryDAO.getByName(name); }

    @Override
    @Transactional
    public List<Category> getUncategorizedCategories(){
        return categoryDAO.getUncategorizedCategories();
    }
}
