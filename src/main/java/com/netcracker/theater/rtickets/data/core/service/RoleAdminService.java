package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.RoleAdmin;
import com.netcracker.theater.rtickets.data.storage.entity.User;

import java.util.Optional;

public interface RoleAdminService {
    RoleAdmin  findByRole (String role);
}
