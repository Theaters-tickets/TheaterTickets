package com.netcracker.theater.rtickets.data.controller.simple;


import com.netcracker.theater.rtickets.data.storage.entity.Comment;
import com.netcracker.theater.rtickets.data.storage.entity.Performance;
import com.netcracker.theater.rtickets.data.storage.entity.Repertoire;
import com.netcracker.theater.rtickets.data.core.service.*;
import com.netcracker.theater.rtickets.data.storage.entity.User;
import com.netcracker.theater.rtickets.data.storage.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.*;

@Controller
public class webControllerUser {
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

    //Information about play
    @GetMapping("/play/{id}")
    String getPlayById(@PathVariable("id") UUID id, Map<String, Object> model, Principal principal) {
        model.put("accessRights", (principal != null ? principal.getName() : ""));
        Repertoire repertoire = repertoireService.getById(id);
        model.put("repertoire", repertoire);
        model.put("categories", repertoireService.getCategoriesByIdOfRepertoire(id));
        model.put("similarRepertoire", repertoireService.getSimilarRepertoire(repertoire.getCategories(), 4));

        //Added by Alisa
        //Comments for repertoire
        List<Comment> comments = new ArrayList<>();
        comments.addAll(repertoire.getComments());

        model.put("comments", comments);
        Comment comment = new Comment();
        model.put("comment", comment);
        //User user = userService.getUserByLogin("user");
        //model.put("user", user);
        return "repertoireInfo";
    }
    @PostMapping( params = "savecomment", value = "/play/{id}")
    public String createComment(@PathVariable("id") UUID id, Model model, @ModelAttribute Comment comment, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            Comment userComm = commentService.getUsersComment(username, id);
            if (userComm != null) {
                commentService.deleteComment(userComm.getId());
            }
            comment.setRepertoire(repertoireService.getById(id));
            comment.setUserName(username);
            commentService.saveComment(comment);
            return "redirect:/play/{id}";
        }
        return "redirect:/login";
    }
    @PostMapping( params = "planned", value = "/play/{id}")
    public String savePlanned(@PathVariable("id") UUID id, Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.getUserByLogin(username);
            user.addRepertoirePlanned(repertoireService.getById(id));
            userService.saveUser(user);
            return "redirect:/play/{id}";
        }
        return "redirect:/login";
    }
    @PostMapping( params = "attended", value = "/play/{id}")
    public String saveAttended(@PathVariable("id") UUID id, Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.getUserByLogin(username);
            user.addRepertoireAttended(repertoireService.getById(id));
            userService.saveUser(user);
            return "redirect:/play/{id}";
        }
        return "redirect:/login";
    }


    //Search page
    @GetMapping("/search")
    String playSearcherGet(Map<String, Object> model, Principal principal)
    {
        if (principal == null) {return "redirect:/login";}
        List<Repertoire> repertoires = repertoireService.filterRepertoire("", "", "", "99");
        model.put("accessRights", (principal != null ? principal.getName() : ""));
        model.put("plays", repertoires);
        return "playSearcher";
    }

    @PostMapping("/search")
    String playSearcherPost(@RequestParam (value="date") String date,
                            @RequestParam (value="name") String name,
                            @RequestParam (value="description") String description,
                            @RequestParam (value="age", defaultValue = "99") String age,
                            Map<String, Object> model,
                            Principal principal){
        if (principal == null) {return "redirect:/login";}
        model.put("accessRights", (principal != null ? principal.getName() : ""));
        model.put("plays", repertoireService.filterRepertoire(date, description, name, age));
        return "playSearcher";
    }

}
