package com.netcracker.theater.rtickets.data.dao;

import com.netcracker.theater.rtickets.data.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PerfomanceDAO extends JpaRepository<Performance, UUID> {
}
