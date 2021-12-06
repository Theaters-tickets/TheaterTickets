package com.netcracker.theater.rtickets.data.controller.simple;

import com.netcracker.theater.rtickets.data.storage.entity.*;
import com.netcracker.theater.rtickets.data.core.service.*;
import com.zaxxer.hikari.util.SuspendResumeLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
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
    //@Autowired
    //GenresService genresService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    PerfomanceService perfomanceService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String redirect(){
        return "redirect:/mainPage";
    }

    //Main page
    @GetMapping("/mainPage")
    public String mainPage(
            Map<String, Object> model,
            Principal principal) {
        List<Repertoire> threeRandom = repertoireService.getThreeRandomRepertoire();
        model.put("accessRights", (principal != null ? principal.getName() : ""));
        model.put("threeRandomRepertoire", threeRandom);
        return "mainPage";
    }



    //Registration page
    @GetMapping("/registration")
    public String getRegistration(Map<String, Object> model)
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistration(Map<String, Object> model,
                                 @RequestBody User user)
    {
        User us = userService.saveUser(user);
        if (us == null){
            //System.out.println("non unique");
            model.put("status", "Non unique login!");
            return "registration";
        }
        else if (us.getId() == null)
        {
            //System.out.println("Error");
            String str = "пользователь уже есть";
        }
        else
        {
            //System.out.println("Success");
            String str = "создался";
        }
        return "redirect:/mainPage";
    }

    //Login page
    @GetMapping("/login")
    public String getLogin(Map<String, Object> model, Principal principal)
    {
        model.put("accessRights", (principal != null ? principal.getName() : ""));
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(Map<String, Object> model, Principal principal) {
        model.put("accessRights", (principal != null ? principal.getName() : ""));
        return "login";
    }


    @GetMapping("/account")
    public String getAccount(Map<String, Object> model, Principal principal){
        if (principal == null) {return "redirect:/login";}
        User user = userService.getUserByLogin(principal.getName());
        model.put("currentUser", user);
        List<Repertoire> plannedRep = new ArrayList<>();
        plannedRep.addAll(user.getRepertoire_planned());
        model.put("plannedRep", plannedRep);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "account";
    }

    /*
    @PostMapping("/account")
    public String postAccount(@RequestParam(value="name") String name,
                              @RequestParam(value="lastName") String lastName,
                              @RequestParam(value="password") String password,
                              Map<String, Object> model){
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

     */
}
