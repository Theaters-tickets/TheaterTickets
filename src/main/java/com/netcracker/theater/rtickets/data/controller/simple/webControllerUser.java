package com.netcracker.theater.rtickets.data.controller.simple;


import com.netcracker.theater.rtickets.data.core.GroupsContainer;
import com.netcracker.theater.rtickets.data.core.TagInfo;
import com.netcracker.theater.rtickets.data.dao.RepertoireDAO;
import com.netcracker.theater.rtickets.data.entity.Comment;
import com.netcracker.theater.rtickets.data.entity.Repertoire;
import com.netcracker.theater.rtickets.data.service.*;
import com.netcracker.theater.rtickets.data.entity.User;
import com.netcracker.theater.rtickets.data.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.swing.text.html.HTML;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.List;
import java.util.*;
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

}
