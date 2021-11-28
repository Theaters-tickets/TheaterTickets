package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.entity.Actor;
import com.netcracker.theater.rtickets.data.entity.User;

import java.util.List;
import java.util.UUID;

//Added by Ilya
//For registration
public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(UUID id);

    void deleteUser(UUID id);

    List<?> getFavoriteCategory(User user);


}
