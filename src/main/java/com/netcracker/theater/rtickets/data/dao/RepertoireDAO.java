package com.netcracker.theater.rtickets.data.dao;

import com.netcracker.theater.rtickets.data.entity.Repertoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RepertoireDAO extends JpaRepository<Repertoire, UUID> {

    @Query(value = "SELECT DISTINCT * from repertoire join performance on repertoire.id = performance.repertoire_id where (performance.date = ?1)", nativeQuery = true)
    public List<Repertoire> getAllRepertoireWithDates(String date);


    //Added by Ilya
    //Query filter
    @Query(value="select distinct repertoire.id, age_min, description, name, title from repertoire join performance on repertoire.id = performance.repertoire_id " +
            "where (performance.date like %:date%) " +
            "and  (repertoire.description like %:description%)" +
            "and  (repertoire.name like %:name%)" +
            "and (cast(repertoire.age_min as signed integer) <= :age)", nativeQuery = true)
    public List<Repertoire> filterRepertoire(@Param("date") String date,
                                             @Param("description") String description,
                                             @Param("name") String name,
                                             @Param("age") String age);




    //Added by Ilya
    //Random repertoire for main page
    @Query(value="SELECT * FROM repertoire" +
            " ORDER BY RAND() LIMIT 3", nativeQuery = true)
    public List<Repertoire> getThreeRandomRepertoire();

    //Added by Ilya
    //Similar repertoire by categories
    @Query(value = "select repertoire.id,repertoire.age_min,repertoire.description,repertoire.name,repertoire.title \n" +
            "from repertoire\n" +
            "join repertoire_categories on repertoire_id = repertoire.id \n" +
            "join category on category_id = category.id\n" +
            "where category.type in (:categorieslike) ORDER by rand() Limit :amount",
            nativeQuery = true)
    public List<Repertoire> getSimilarRepertoire(@Param("categorieslike") List<String> categorieslike,
                                                 @Param("amount") int amount);
}
