package com.netcracker.theater.rtickets.data.controller.rest;

import com.netcracker.theater.rtickets.data.dao.ParameterDAO;
import com.netcracker.theater.rtickets.data.dao.RoleAdminDAO;
import com.netcracker.theater.rtickets.data.dao.UserDAO;
import com.netcracker.theater.rtickets.data.entity.Parameter;
import com.netcracker.theater.rtickets.data.entity.RoleAdmin;
import com.netcracker.theater.rtickets.data.entity.User;
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

    @Autowired
    private ParameterDAO parameterDAO;

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

    @PostMapping("/newParam")
    public void saveUser(@RequestBody Parameter parameter)
    {
        parameterDAO.save(parameter);
    }


}