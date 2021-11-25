package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.entity.*;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(UUID id);

    void deleteUser(UUID id);

    List<?> getFavoriteCategory(User user);


}
