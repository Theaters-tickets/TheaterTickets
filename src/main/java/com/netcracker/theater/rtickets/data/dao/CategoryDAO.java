package com.netcracker.theater.rtickets.data.dao;

import com.netcracker.theater.rtickets.data.entity.Category;
import com.netcracker.theater.rtickets.data.entity.Repertoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CategoryDAO extends JpaRepository<Category, UUID> {

    //Added by Ilya
    //To get category with same name as in frontend
    @Query(value = "SELECT * from Category where (category.name = :name)", nativeQuery = true)
    public List<Category> getCategoryWithName(@Param("name") String name);

    //Added by Ilya
    //All uncategorized categories
    @Query(value="Select * from category where category.type ='Uncategorized'", nativeQuery = true)
    public List<Category> getUncategorizedCategories();
}
