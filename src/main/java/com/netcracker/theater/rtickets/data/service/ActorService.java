package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.entity.Actor;

import java.util.List;
import java.util.UUID;

public interface ActorService {
    List<Actor> getAllActors();

    void saveActor(Actor actor);

    Actor getActor(UUID id);

    void deleteActor(UUID id);

}
