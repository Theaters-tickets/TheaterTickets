package com.netcracker.theater.rtickets.dao;

import com.netcracker.theater.rtickets.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreDAO extends JpaRepository<Theatre, Integer> {
}
