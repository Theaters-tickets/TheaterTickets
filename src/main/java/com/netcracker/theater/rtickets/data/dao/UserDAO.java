package com.netcracker.theater.rtickets.data.dao;

import com.netcracker.theater.rtickets.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDAO extends JpaRepository<User, UUID> {
}
