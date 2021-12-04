package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.entity.Recommendation;
import com.netcracker.theater.rtickets.data.storage.entity.RoleAdmin;
import com.netcracker.theater.rtickets.data.storage.entity.User;
import com.netcracker.theater.rtickets.data.storage.repository.RoleAdminDAO;
import com.netcracker.theater.rtickets.data.storage.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleAdminDAO roleAdminDAO;

    @Autowired
    private RoleAdminService roleAdminService;

    @Autowired
    private UserServiceImpl userService;



    public User findByLogin(String login)
    {
        Optional<User> user = userDAO.findByLogin(login);
        return user.orElse(User.builder().build());
    }

    @Override
    @Transactional
    public List<User> getAllUsers()
    {
        return userDAO.findAll();
    }


    @Override
    @Transactional
    public User saveUser(User man)
    {
        User user = this.findByLogin(man.getLogin());
        if (user.getId() == null) {
            this.saveMan(man, "ROLE_USER");
            return user;
        }
        else return null;
    }


    @Override
    @Transactional
    public User saveAdmin(User man) {
        User user = this.findByLogin(man.getLogin());
        if (user.getId() == null) {
            this.saveMan(man, "ROLE_ADMIN");
            return user;
        }
        else return null;
    }

    @Override
    @Transactional
    public User getUser(UUID id) {
        Optional<User> optional = userDAO.findById(id);
        return optional.orElse(null);
    }

    @Transactional
    private void saveMan(User man, String roleAdmin)
    {
        RoleAdmin role = roleAdminService.findByRole(roleAdmin);
        if (role != null)
        {
            userDAO.save(User.builder()
                    .roleAdmin(role)
                    .login(man.getLogin())
                    .password(new BCryptPasswordEncoder().encode(man.getPassword()))
                    .name(man.getName())
                    .enabled(true)
                    .build());
        }
    }

    @Override
    @Transactional
    public void deleteUser(UUID id) { userDAO.deleteById(id); }

    @Override
    @Transactional
    public List<Recommendation> getUsersRecommendations(User user) { return userDAO.getUsersRecommendations(user); }

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
        User user = this.findByLogin(login);

        if (user == null)  return null;

        RoleAdmin roleNames1 = user.getRoleAdmin();

        GrantedAuthority authority = new SimpleGrantedAuthority(roleNames1.getRole());
        List<GrantedAuthority> grantList = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(), Arrays.asList(authority));
    }
}
