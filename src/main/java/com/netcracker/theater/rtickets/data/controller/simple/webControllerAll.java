package com.netcracker.theater.rtickets.data.controller.simple;

import com.netcracker.theater.rtickets.data.entity.Repertoire;
import com.netcracker.theater.rtickets.data.entity.User;
import com.netcracker.theater.rtickets.data.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class webControllerAll {
    @Autowired
    TheatreService theatreService;
    @Autowired
    RepertoireService repertoireService;
    @Autowired
    GenresService genresService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    PerfomanceService perfomanceService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    //Main page
    @GetMapping("/mainPage")
    public String mainPage(
            Map<String, Object> model) {
        List<Repertoire> threeRandom = repertoireService.getThreeRandomRepertoire();
        //This should be checked via spring security
        //But now it's hardcoded for admin
        model.put("accessRights", "admin");
        //
        model.put("threeRandomRepertoire", threeRandom);
        return "mainPage";


    }

    //Registration page
    @GetMapping("/registration")
    public String getRegistration(Map<String, Object> model){
        return "registration";
    }
    @PostMapping("/registration")
    public void postRegistration(
            @RequestBody User user)
    {
        try {
            userService.saveUser(user);
        }
        //Error if user with same login
        catch (Exception e){
            System.out.println(e.getCause());
        }
    }

    //Login page
    @GetMapping("/login")
    public String getLogin(Map<String, Object> model){ return "login";}

    @PostMapping("/login")
    public String postLogin(
            @RequestParam(value="username") String username,
            @RequestParam (value="password") String password,
            Map<String, Object> model) {
        //To-do - authentication
        if (username.equals("root") && password.equals("root")) {
            model.put("status", "OK");
        } else {
            model.put("status", "ERROR");
        }
        return "login";
    }
}
