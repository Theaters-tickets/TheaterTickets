package com.netcracker.theater.rtickets.data.controller.simple;

import com.netcracker.theater.rtickets.data.dao.RepertoireDAO;
import com.netcracker.theater.rtickets.data.entity.Comment;
import com.netcracker.theater.rtickets.data.entity.Repertoire;
import com.netcracker.theater.rtickets.data.service.*;
import com.netcracker.theater.rtickets.data.entity.User;
import com.netcracker.theater.rtickets.data.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.List;
import java.util.*;
import java.util.*;

@Controller
public class webController {
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



    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @Autowired
    UserService userService;

    //Main page
    @GetMapping("/mainPage")
    public String mainPage(
            Map<String, Object> model) {
        List<Repertoire> threeRandom = repertoireService.getThreeRandomRepertoire();
        model.put("threeRandomRepertoire", threeRandom);
        List<String> images = new ArrayList<>();
        images.add(threeRandom.get(0).getPictures().iterator().next().getImage());
        images.add(threeRandom.get(1).getPictures().iterator().next().getImage());
        images.add(threeRandom.get(2).getPictures().iterator().next().getImage());
        model.put("images", images);
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
            @RequestParam (value="login") String login,
            @RequestParam (value="password") String password,
            Map<String, Object> model) {
        //To-do - authentication
        if (login.equals("root") && password.equals("root")) {
            model.put("status", "OK");
        } else {
            model.put("status", "ERROR");
        }
        return "login";
    }



    //Information about play
    @GetMapping("/play/{id}")
    String getPlayById(@PathVariable("id") UUID id, Map<String, Object> model) {
        Repertoire repertoire = repertoireService.getById(id);
        model.put("repertoire", repertoire);

        List<Comment> comments = List.copyOf(repertoire.getComments());
        model.put("comments", comments);
        Comment comment = new Comment();
        model.put("comment", comment);
        return "repertoireInfo";
    }
    @PostMapping("/play/{id}")
    public String createComment(@PathVariable("id") UUID id, Model model, @ModelAttribute Comment comment) {
        Repertoire repertoire = repertoireService.getById(id);
        repertoire.addComment(comment);
        repertoireService.saveRep(repertoire);
        return "redirect:/play/{id}";
    }

    //Search page
    @GetMapping("/search")
    String playSearcherGet(Map<String, Object> model) {
        model.put("plays", repertoireService.getAllRepertoire());
        return "playSearcher";
    }
    @PostMapping("/search")
    String playSearcherPost(@RequestParam (value="date") String date,
                                    @RequestParam (value="name") String name,
                                    @RequestParam (value="description") String description,
                                    @RequestParam (value="age", defaultValue = "99") String age,
                                    Map<String, Object> model){
        model.put("plays", repertoireService.filterRepertoire(date, description, name, age));
        return "playSearcher";
    }

    //Page with tags
    @GetMapping("/adminTags")
    public String adminTagsGet(Map<String, Object> model){
        GroupsContainer groupsContainer = new GroupsContainer(categoryService.getAllCategories());
        model.put("groupsContainer", groupsContainer);
        model.put("categoryNames", groupsContainer.mapContainer.keySet());
        return "tagsOnStart1";
    }

    @PostMapping("/adminTags")
    public void adminTagsPost(
            @RequestBody(required = false) List<TagInfo> TagInfos,
            Map<String, Object> model){
        for (TagInfo newTagType : TagInfos){
            categoryService.updateType(newTagType.tag, newTagType.parent);}
    }
}