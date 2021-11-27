package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.dao.CategoryDAO;
import com.netcracker.theater.rtickets.data.dao.UserDAO;
import com.netcracker.theater.rtickets.data.entity.Category;
import com.netcracker.theater.rtickets.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

//Added by Ilya
//For registration
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user){
        userDAO.save(user);
    }

    @Override
    public User getUser(UUID id){return userDAO.getById(id);}

}
