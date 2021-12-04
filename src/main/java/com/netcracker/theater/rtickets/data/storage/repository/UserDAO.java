package com.netcracker.theater.rtickets.data.storage.repository;

import com.netcracker.theater.rtickets.data.storage.entity.Recommendation;
import com.netcracker.theater.rtickets.data.storage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface UserDAO extends JpaRepository<User, UUID> {
    @Query("select tags.recommendation as rec from Performance p join p.repertoire.categories tags" +
            " where (((?1  member of p.usersAttended) or (?1  member of p.usersPlanned)) " +
            "and (tags.recommendation.name not like 'default'))" +
            "group by tags order by count(tags) desc")
    List<Recommendation> getUsersRecommendations(User user);

    //Added by Ilya
    //todo delete
    @Query(value = "select * from user where user.login = :login", nativeQuery = true)
    User getUserByLogin(@Param("login") String login);

    //Added by Ilya
    //todo delete
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE user " +
            "SET user.name= :name, user.last_name= :lastName " +
            "WHERE user.login = :login", nativeQuery = true)
    void updateUser(@Param("login") String login,
                    @Param("name") String name,
                    @Param("lastName") String lastName);


    @Query("SELECT u FROM User u WHERE (:login is null or u.login = :login) and" +
            " (:password is null or u.password = :password) and " +
            " (:email is null or u.email = :email)")
    Set<User> findByParameters(@Param("login") String login,
                               @Param("password") String password,
                               @Param("email") String email);


    Optional<User> findByLogin(String login);
}
