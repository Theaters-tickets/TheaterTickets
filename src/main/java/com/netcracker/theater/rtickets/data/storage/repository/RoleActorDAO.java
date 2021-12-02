package com.netcracker.theater.rtickets.data.storage.repository;

import com.netcracker.theater.rtickets.data.storage.entity.RoleActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface RoleActorDAO extends JpaRepository<RoleActor, UUID> {
    @Query("select role from RoleActor role where role.name = ?1")
    RoleActor getRoleByName(String name);
}
