package com.netcracker.theater.rtickets.data.controller.simple;


import com.netcracker.theater.rtickets.data.entity.Comment;
import com.netcracker.theater.rtickets.data.entity.Repertoire;
import com.netcracker.theater.rtickets.data.service.*;
import com.netcracker.theater.rtickets.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Controller
public class webControllerUser {
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

    //Information about play
    @GetMapping("/play/{id}")
    String getPlayById(@PathVariable("id") UUID id, Map<String, Object> model) {
        Repertoire repertoire = repertoireService.getById(id);
        model.put("repertoire", repertoire);
        model.put("categories", repertoireService.getCategoriesByIdOfRepertoire(id)); //Added by Ilya categories of the repertoire
        //model.put("theatre", repertoire.getPerformances().iterator().next().getTheatre()!=null ? repertoire.getPerformances().iterator().next().getTheatre() : "error");
        model.put("similarRepertoire", repertoireService.getSimilarRepertoire(repertoire.getCategories(), 3));

        //Added by Alisa
        //Comments for repertoire
        List<Comment> comments = new ArrayList<>();
        comments.addAll(repertoire.getComments());

        model.put("comments", comments);
        Comment comment = new Comment();
        model.put("comment", comment);
        User user = new User("ussser", "1234");
        model.put("user", user);
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

}
