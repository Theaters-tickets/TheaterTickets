package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.Category;
import com.netcracker.theater.rtickets.data.storage.entity.Repertoire;
import com.netcracker.theater.rtickets.data.storage.entity.Theatre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RepertoireService {
    List<Repertoire> getAllRepertoire();


    void saveRep(Repertoire repertoire);

    Repertoire getById(UUID id);

    List<Repertoire> getRepertoireWithDates(String date);

    //Added by Ilya
    //Filter repertoire
    List<Repertoire> filterRepertoire(String date, String description, String name, String age);

    //Added by Ilya
    //Random three Repertoire for main page
    List<Repertoire> getThreeRandomRepertoire();

    //Added by Ilya
    //Categories as list for repertoire
    List<String> getCategoriesByIdOfRepertoire(UUID id);

    //Added by Ilya
    //Theatre for repertoire
    Theatre getTheatreByIdOfRepertoire(UUID id);

    //Added by Ilya
    //Get similar repertoire by tags
    List<Repertoire> getSimilarRepertoire(Set<Category> categories, int amount);

}
