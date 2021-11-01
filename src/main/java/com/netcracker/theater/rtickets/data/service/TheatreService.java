package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.entity.Theatre;

import java.util.List;
import java.util.UUID;

public interface TheatreService {
    List<Theatre> getAllTheatre();

    void saveTheatre(Theatre theatre);

    Theatre getTheatre(UUID id);

    void deleteTheatre(UUID id);
}
