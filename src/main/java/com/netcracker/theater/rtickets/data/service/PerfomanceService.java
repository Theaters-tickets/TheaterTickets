package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.entity.Performance;


import java.util.List;

public interface PerfomanceService {
    List<Performance> getAllPerformance();
    void savePer(Performance performance);
}
