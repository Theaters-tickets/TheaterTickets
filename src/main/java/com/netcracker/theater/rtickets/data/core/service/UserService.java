package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.Recommendation;
import com.netcracker.theater.rtickets.data.storage.entity.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService {
    List<User> getAllUsers();

    User saveUser(User man);

    User saveAdmin(User man);

    void deleteUserById(UUID id);

    Set<User> findByParameters(String login, String password, String email); //метод для поиска пользователя по его параметрам, можно указать параметр == null

    User getUser(UUID id);

    void deleteUser(UUID id);

    List<Recommendation> getUsersRecommendations(User user);

    //Added by Ilya
    //Getting user by name for security
    User getUserByLogin(String login);

    //Added by Ilya
    //To update user
    void updateUser(User user, String name, String lastName);

    boolean isStringOnlyAlphabet(String str);

    boolean isStringOnlyAlphabetAndNumbersAndSymbols(String str);

}
