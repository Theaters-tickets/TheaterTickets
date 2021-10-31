package com.netcracker.theater.rtickets.data.dao;

import com.netcracker.theater.rtickets.data.entity.RoleActor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleActorDAO extends JpaRepository<RoleActor, UUID> {
}
