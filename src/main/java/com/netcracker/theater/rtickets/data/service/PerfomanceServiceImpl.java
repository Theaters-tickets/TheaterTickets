package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.dao.PerfomanceDAO;
import com.netcracker.theater.rtickets.data.entity.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public void savePer(Performance performance) {
        perfomanceDAO.save(performance);
    }

}
