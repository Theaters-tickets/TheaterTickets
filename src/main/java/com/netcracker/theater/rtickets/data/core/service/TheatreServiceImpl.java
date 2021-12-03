package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.repository.TheatreDAO;
import com.netcracker.theater.rtickets.data.storage.entity.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class TheatreServiceImpl implements TheatreService{

    @Autowired
    private TheatreDAO theatreDAO;

    @Override
    @Transactional
    public List<Theatre> getAllTheatre() {
        return theatreDAO.findAll();
    }

    @Override
    @Transactional
    public void saveTheatre(Theatre theatre) {
        theatreDAO.save(theatre);
    }

    @Override
    @Transactional
    public Theatre getTheatre(UUID id) {
        return theatreDAO.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteTheatre(UUID id) {
        theatreDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Theatre getTheatreByNumber(Long number) { return theatreDAO.getByNumber(number); }

    @Override
    @Transactional
    public boolean isExistByName(String name) { return theatreDAO.isExistByName(name); }
}
