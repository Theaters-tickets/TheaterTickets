package com.netcracker.theater.rtickets.data.storage.repository;

import com.netcracker.theater.rtickets.data.storage.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PerfomanceDAO extends JpaRepository<Performance, UUID> {

}
