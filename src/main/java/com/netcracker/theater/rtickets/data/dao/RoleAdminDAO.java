package com.netcracker.theater.rtickets.data.dao;

import com.netcracker.theater.rtickets.data.entity.RoleAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleAdminDAO extends JpaRepository<RoleAdmin, UUID> {
}
