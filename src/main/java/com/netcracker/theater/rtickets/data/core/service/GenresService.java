package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.Genre;

import java.util.List;
import java.util.UUID;

public interface GenresService {
    List<Genre> getAllGenres();

    void saveGenre(Genre genre);

    Genre getGenre(UUID id);

    void deleteGenre(UUID id);
}
