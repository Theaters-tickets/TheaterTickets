package com.netcracker.theater.rtickets.data.dao;

import com.netcracker.theater.rtickets.data.entity.Repertoire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepertoireDAO extends JpaRepository<Repertoire, UUID> {
}
