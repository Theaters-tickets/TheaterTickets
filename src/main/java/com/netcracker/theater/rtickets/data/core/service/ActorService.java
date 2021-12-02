package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.Actor;

import java.util.List;
import java.util.UUID;

public interface ActorService {
    List<Actor> getAllActors();

    void saveActor(Actor actor);

    Actor getActor(UUID id);

    void deleteActor(UUID id);

}
