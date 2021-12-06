package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.repository.PerfomanceDAO;
import com.netcracker.theater.rtickets.data.storage.entity.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class PerfomanceServiceImpl implements PerfomanceService {
    @Autowired
    PerfomanceDAO perfomanceDAO;

    @Override
    @Transactional
    public List<Performance> getAllPerformance() {
        return perfomanceDAO.findAll();
    }

    @Override
    @Transactional
    public void savePer(Performance performance) {
        perfomanceDAO.save(performance);
    }

    //Added by Ilya
    //To get performance by id
    @Override
    @Transactional
    public Performance getById(UUID id){
        return perfomanceDAO.getById(id);
    }

}
