package com.netcracker.theater.rtickets.data.dao;

import com.netcracker.theater.rtickets.data.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TheatreDAO extends JpaRepository<Theatre, UUID> {
}
