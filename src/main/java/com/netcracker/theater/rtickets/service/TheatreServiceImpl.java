package com.netcracker.theater.rtickets.service;

import com.netcracker.theater.rtickets.dao.TheatreDAO;
import com.netcracker.theater.rtickets.entity.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public Theatre getTheatre(int id) {
        return theatreDAO.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteTheatre(int id) {
        theatreDAO.deleteById(id);
    }
}
