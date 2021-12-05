package com.netcracker.theater.rtickets.data.controller.rest;

import com.netcracker.theater.rtickets.data.core.service.UserService;
import com.netcracker.theater.rtickets.data.storage.entity.User;
import com.netcracker.theater.rtickets.data.storage.repository.UserDAO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Tag(name = "User", description = "The User API")
@RestController
@RequestMapping("/users")
public class RestControllerUsers {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService usersService;

    @GetMapping("/allUser")
    public List<User> showAllUsers()
    {
        return usersService.getAllUsers();
    }

    @PostMapping("/newUser")
    public void saveUser(@RequestBody User user)
    {
        usersService.saveUser(user);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable UUID id)
    {
        usersService.deleteUserById(id);
    }






    @PostMapping("/saveDataUser")
    public void saveDataUser(@RequestBody User user )
    {
        Set<User> users = usersService.findByParameters(user.getLogin(), user.getPassword(), user.getEmail());
        if (!users.isEmpty() && users.size() == 1)
        {
            users.iterator().next().setName(user.getName());
            users.iterator().next().setLast_name(user.getLast_name());
            users.iterator().next().setPatronymic(user.getPatronymic());
            users.iterator().next().setBirthday(user.getBirthday());

            usersService.saveUser(users.iterator().next());
        }
    }




    @PostMapping("/saveUser/{email}.{login}.{password}")
    public void saveUser(@PathVariable String email,
                         @PathVariable String login,
                         @PathVariable String password) //просто тестовый
    {
        if (EmailValidator.getInstance().isValid(email)) //проверка, что это e_mail
        {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            Set<User> users = usersService.findByParameters(user.getLogin(), user.getPassword(), user.getEmail());
            if (users.isEmpty() && users.size() == 0)
            {
                usersService.saveUser(user);
            }
        }
    }


    @PostMapping("/saveDataPasswordUser")
    public void saveNewPasswdordUser(@RequestBody User user )
    {
        Set<User> users = usersService.findByParameters(user.getLogin(), null, user.getEmail());
        if (!users.isEmpty() && users.size() == 1)
        {
            users.iterator().next().setPassword(user.getPassword());
            usersService.saveUser(users.iterator().next());
        }
    }
    @PostMapping("/saveDataEmailUser")
    public void saveNewEmailUser(@RequestBody User user )
    {
        Set<User> users = usersService.findByParameters(user.getLogin(), user.getPassword(), null);
        if (!users.isEmpty() && users.size() == 1)
        {
            users.iterator().next().setEmail(user.getEmail());
            usersService.saveUser(users.iterator().next());
        }
    }
    @PostMapping("/saveDataLoginUser")
    public void saveNewLoginUser(@RequestBody User user )
    {
        Set<User> users = usersService.findByParameters(null, user.getPassword(), user.getEmail());
        if (!users.isEmpty() && users.size() == 1)
        {
            users.iterator().next().setLogin(user.getLogin());
            usersService.saveUser(users.iterator().next());
        }
    }

    //редактирование данныех пользователя
    @PostMapping("/saveDataUser/{email}.{login}.{password}.{name}.{last_name}.{patronymic}")
    public void saveDataUser(@PathVariable String email,
                             @PathVariable String login,
                             @PathVariable String password,
                             @PathVariable String name,
                             @PathVariable String last_name,
                             @PathVariable String patronymic
                             )
    {
        Set<User> users = usersService.findByParameters(login, new BCryptPasswordEncoder().encode(password), email);
        if (!users.isEmpty() && users.size() == 1)
        {
            usersService.saveUser(User.builder()
                    .id(users.iterator().next().getId())
                    .roleAdmin(users.iterator().next().getRoleAdmin())
                    .email(email)
                    .login(login)
                    .password(new BCryptPasswordEncoder().encode(password))
                    .name(name)
                    .last_name(last_name)
                    .patronymic(patronymic)
                    .enabled(true)
                    .build());
        }
    }
    //редактирование данныех пользователя
    /*
    @PostMapping("/saveDataUser")
    public void saveDataUser2(@RequestBody User user)
    {
        Set<User> users = usersService.findByParameters(user.getLogin(), new BCryptPasswordEncoder().encode(user.getPassword()), user.getEmail());
        if (!users.isEmpty() && users.size() == 1)
        {
            usersService.saveUser(User.builder()
                    .id(users.iterator().next().getId())
                    .roleAdmin(users.iterator().next().getRoleAdmin())
                    .email(user.getEmail())
                    .login(user.getLogin())
                    .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                    .name(user.getName())
                    .last_name(user.getLast_name())
                    .patronymic(user.getPatronymic())
                    .enabled(true)
                    .build());
        }
    }

     */

}