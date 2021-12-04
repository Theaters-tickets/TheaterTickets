package com.netcracker.theater.rtickets.data.storage.repository;

import com.netcracker.theater.rtickets.data.storage.entity.RoleAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleAdminDAO extends JpaRepository<RoleAdmin, UUID> {
    Optional<RoleAdmin> findByRole (String role);
}
