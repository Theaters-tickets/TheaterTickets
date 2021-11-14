package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.dao.RepertoireDAO;
import com.netcracker.theater.rtickets.data.entity.Repertoire;

import java.util.List;
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

}
