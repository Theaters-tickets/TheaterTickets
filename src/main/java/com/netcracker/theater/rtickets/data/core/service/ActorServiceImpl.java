package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.repository.ActorDAO;
import com.netcracker.theater.rtickets.data.storage.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorDAO actorDAO;

    @Override
    @Transactional
    public List<Actor> getAllActors() { return actorDAO.findAll();}

    @Override
    @Transactional
    public void saveActor(Actor actor) {actorDAO.save(actor);}

    @Override
    @Transactional
    public Actor getActor(UUID id)
    {
        return actorDAO.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteActor(UUID id) { actorDAO.deleteById(id); }
}
