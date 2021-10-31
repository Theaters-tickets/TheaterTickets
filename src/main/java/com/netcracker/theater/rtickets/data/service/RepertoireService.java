package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.entity.Repertoire;

import java.util.List;

public interface RepertoireService {
    List<Repertoire> getAllRepertoire();


    void saveRep(Repertoire repertoire);
}
