package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.dao.RoleActorDAO;
import com.netcracker.theater.rtickets.data.entity.RoleActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class RoleActorSevriceImpl implements RoleActorService{
    @Autowired
    private RoleActorDAO roleActorDAO;

    @Override
    @Transactional
    public List<RoleActor> getAllRoles() { return roleActorDAO.findAll();};

    @Override
    @Transactional
    public void saveRole(RoleActor roleActor) {roleActorDAO.save(roleActor);};

    @Override
    @Transactional
    public RoleActor getRole(UUID id) {return roleActorDAO.findById(id).get();};

    @Override
    @Transactional
    public void deleteRole(UUID id) { roleActorDAO.deleteById(id); };

    @Override
    @Transactional
    public RoleActor getRoleByName(String name) { return roleActorDAO.getRoleByName(name); };

}
