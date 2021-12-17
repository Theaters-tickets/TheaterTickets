package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.RoleActor;


import java.util.List;
import java.util.UUID;

public interface RoleActorService {
    List<RoleActor> getAllRoles();

    void saveRole(RoleActor roleActor);

    RoleActor getRole(UUID id);

    void deleteRole(UUID id);

    RoleActor getRoleByName(String name);
}
