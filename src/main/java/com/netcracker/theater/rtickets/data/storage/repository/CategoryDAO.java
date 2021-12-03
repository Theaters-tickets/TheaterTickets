package com.netcracker.theater.rtickets.data.storage.repository;

import com.netcracker.theater.rtickets.data.storage.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CategoryDAO extends JpaRepository<Category, UUID> {

    //Added by Ilya
    //To get category with same name as in frontend
    @Query(value = "SELECT * from Category where (category.name = :name)", nativeQuery = true)
    List<Category> getCategoryWithName(@Param("name") String name);

    @Query("select cat from Category cat where cat.name = ?1")
    Category getByName(String name);

    //Added by Ilya
    //All uncategorized categories
    @Query("Select cat from Category cat where cat.recommendation.name ='Uncategorized'")
    List<Category> getUncategorizedCategories();
}
