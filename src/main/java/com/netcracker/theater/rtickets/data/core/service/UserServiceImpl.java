package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.repository.RoleAdminDAO;
import com.netcracker.theater.rtickets.data.storage.repository.UserDAO;
import com.netcracker.theater.rtickets.data.storage.entity.User;
import com.netcracker.theater.rtickets.data.storage.entity.UserRole;
import com.netcracker.theater.rtickets.data.storage.repository.UsersRolesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

//Added by Ilya
//For registration
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleAdminDAO roleAdminDAO;

    @Autowired
    private UsersRolesDAO usersRolesDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() { return userDAO.findAll(); }

    @Override
    @Transactional
    public void saveUser(User user) { userDAO.save(user); }

    @Override
    @Transactional
    public User getUser(UUID id) {
        Optional<User> optional = userDAO.findById(id);
        return optional.orElse(null);
    }

    @Override
    @Transactional
    public void deleteUser(UUID id) { userDAO.deleteById(id); }

    @Override
    @Transactional
    public List<?> getFavoriteCategory(User user) { return userDAO.getFavoriteCategory(user); }

    //Added for security purposes
    @Override
    @Transactional
    public User getUserByLogin(String login) {return userDAO.getUserByLogin(login);}

    @Override
    @Transactional
    public void updateUser(User user, String name, String lastName){
        name = name.equals("") ? user.getName() : name;
        lastName = lastName.equals("") ? user.getLast_name() : lastName;
        userDAO.updateUser(user.getLogin(),name, lastName);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = this.userDAO.findByLogin(login);

        if (user == null) {
            System.out.println("User not found! " + login);
            //throw new UsernameNotFoundException("User " + login + " was not found in the database");
            return null;
        }
        System.out.println("Found User: " + user);

        Set<UserRole> roleNames = usersRolesDAO.findByUser_id(user.getId());

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (UserRole role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole().getName());
                grantList.add(authority);
            }
        }

        return new org.springframework.security.core.userdetails.User
                (user.getLogin(),user.getPassword(), grantList);
    }
}
