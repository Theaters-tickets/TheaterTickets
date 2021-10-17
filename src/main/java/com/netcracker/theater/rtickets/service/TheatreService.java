package com.netcracker.theater.rtickets.service;

import com.netcracker.theater.rtickets.entity.Theatre;

import java.util.List;

public interface TheatreService {
    public List<Theatre> getAllTheatre();

    public void saveTheatre(Theatre theatre);

    public Theatre getTheatre(int id);

    public void deleteTheatre(int id);
}
