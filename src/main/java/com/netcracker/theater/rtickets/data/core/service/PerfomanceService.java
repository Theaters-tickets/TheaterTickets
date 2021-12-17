package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.Performance;


import java.util.List;
import java.util.UUID;

public interface PerfomanceService {
    List<Performance> getAllPerformance();
    void savePer(Performance performance);

    //Added by Ilya
    //To get performance by id
    Performance getById(UUID id);
}
