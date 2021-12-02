package com.netcracker.theater.rtickets.data.storage.repository;

import com.netcracker.theater.rtickets.data.storage.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface UsersRolesDAO extends JpaRepository<UserRole, UUID> {

    Set<UserRole> findByUser_id(UUID id);

}
