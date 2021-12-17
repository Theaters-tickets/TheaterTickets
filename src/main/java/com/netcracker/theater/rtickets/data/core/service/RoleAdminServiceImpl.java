package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.RoleAdmin;
import com.netcracker.theater.rtickets.data.storage.entity.User;
import com.netcracker.theater.rtickets.data.storage.repository.RoleAdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class RoleAdminServiceImpl implements RoleAdminService {

    @Autowired
    RoleAdminDAO roleAdminDAO;

    @Override
    @Transactional
    public RoleAdmin findByRole(String name) {
        Optional<RoleAdmin> role = roleAdminDAO.findByRole(name);
        return role.orElse(null);
    }

}
