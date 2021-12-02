package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.Theatre;

import java.util.List;
import java.util.UUID;

public interface TheatreService {
    List<Theatre> getAllTheatre();

    void saveTheatre(Theatre theatre);

    Theatre getTheatre(UUID id);

    void deleteTheatre(UUID id);

    Theatre getTheatreByNumber(Long number);

    boolean isExistByName(String name);

}
