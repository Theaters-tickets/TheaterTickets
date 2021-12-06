/*package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.repository.GenreDAO;
import com.netcracker.theater.rtickets.data.storage.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class GenresServiceImpl implements GenresService{

    @Autowired
    private GenreDAO genreDAO;

    @Override
    @Transactional
    public List<Genre> getAllGenres() {
        return genreDAO.findAll();
    }

    @Override
    @Transactional
    public void saveGenre(Genre genre) {
        genreDAO.save(genre);
    }

    @Override
    @Transactional
    public Genre getGenre(UUID id) {
        return genreDAO.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteGenre(UUID id) {
        genreDAO.deleteById(id);
    }
}

 */
