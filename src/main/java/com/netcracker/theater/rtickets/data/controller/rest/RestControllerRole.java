package com.netcracker.theater.rtickets.data.controller.rest;

//import com.netcracker.theater.rtickets.data.storage.repository.ParameterDAO;
import com.netcracker.theater.rtickets.data.storage.repository.RoleAdminDAO;
import com.netcracker.theater.rtickets.data.storage.repository.UserDAO;
//import com.netcracker.theater.rtickets.data.storage.entity.Parameter;
import com.netcracker.theater.rtickets.data.storage.entity.RoleAdmin;
import com.netcracker.theater.rtickets.data.storage.entity.User;
import com.netcracker.theater.rtickets.data.core.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "role", description = "The role API")
@RestController
@RequestMapping("/role")
public class RestControllerRole {

    @Autowired
    private RoleAdminDAO roleAdminDAO;

    @Autowired
    private UserDAO userDAO;

    //@Autowired
    //private ParameterDAO parameterDAO;

    @Autowired
    private UserService userService;


    @Operation(summary = "все жанры")
    @GetMapping("/all")
    public List<RoleAdmin> showAllRoles()
    {
        return roleAdminDAO.findAll();
    }

    @PostMapping("/new")
    public void saveRoles(@RequestBody RoleAdmin role)
    {
        roleAdminDAO.save(role);
    }


    @DeleteMapping("/role/delete/{id}")
    public void deleteRole(@PathVariable UUID id)
    {
        roleAdminDAO.deleteById(id);
    }

    @GetMapping("/allUser")
    public List<User> showAllUsers()
    {
        return userDAO.findAll();
    }

    @PostMapping("/newUser")
    public void saveUser(@RequestBody User user)
    {
        userDAO.save(user);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable UUID id)
    {
        userDAO.deleteById(id);
    }
/*
    @PostMapping("/newParam")
    public void saveUser(@RequestBody Parameter parameter)
    {
        parameterDAO.save(parameter);
    }

 */

    @Operation(summary = "dell")
    @GetMapping("/del")
    public void usad()
    {
        List<User> users = userDAO.findAll();
        users.forEach(u -> userDAO.delete(u));

        List<RoleAdmin> roles = roleAdminDAO.findAll();
        roles.forEach(r -> roleAdminDAO.delete(r));
    }

    @Operation(summary = "add")
    @GetMapping("/add")
    public void usad1()
    {
        RoleAdmin rU = RoleAdmin.builder().role("ROLE_USER").build();
        RoleAdmin rA = RoleAdmin.builder().role("ROLE_ADMIN").build();
        roleAdminDAO.save(rU);
        roleAdminDAO.save(rA);

        String us = "user";
        String ad = "admin";

        String adP = "$2y$10$LjVke5l9R7bAPP4.fqcSTOR.jdXTp8Q8JsHNHCf08Xwvi2zwcLDY2";
        String usP = "$2y$10$pzEfgemPkzASOsSqgN5eBeydwy3KquKqpVyo4oNGoMcp3Dl3Rm4HK";

        RoleAdmin r = RoleAdmin.builder().role("ROLE_USER").build();
        User user = User.builder().roleAdmin(rU).login(us).password(usP).name(us).enabled(true).build();
        User admin = User.builder().roleAdmin(rA).login(ad).password(adP).name(ad).enabled(true).build();

        userDAO.save(user);
        userDAO.save(admin);
    }

}