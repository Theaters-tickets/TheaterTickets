package com.netcracker.theater.rtickets.data.controller.simple;

import com.netcracker.theater.rtickets.data.storage.entity.*;
import com.netcracker.theater.rtickets.data.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    public void postRegistration(Map<String, Object> model,
                                 @RequestBody User user)
    {
        //Todo add check for uniqueness
        userService.saveUser(user);

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


    @GetMapping("/account")
    public String getAccount(Map<String, Object> model, Principal principal){
        String username;
        try {
            username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        }
        catch (Exception e) {
            return "redirect:/login";
        }
        User user = userService.getUserByLogin(username);
        model.put("currentUser", user);
        List<Performance> plannedPerf = new ArrayList<>();
        plannedPerf.addAll(user.getPerformances_planned());
        model.put("plannedPerf", plannedPerf);
        Performance perf = new Performance();
        model.put("perf", perf);
        return "account";
    }

    @PostMapping("/account")
    public String postAccount(@RequestParam(value="name") String name,
                              @RequestParam(value="lastName") String lastName,
                              @RequestParam(value="password") String password,
                              Map<String, Object> model){
        //Todo synthesise with authorization
        User user = userService.getUserByLogin("user");
        if (user.getPassword().equals(password)){
            userService.updateUser(user, name, lastName);
            model.put("status", "Changed!");
        }
        else{
            model.put("status", "Error!");
        }
        //Todo update user by values
        model.put("currentUser", user);

        return "account";
    }
}
