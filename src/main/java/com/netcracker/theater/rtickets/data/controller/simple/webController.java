package com.netcracker.theater.rtickets.data.controller.simple;

import com.netcracker.theater.rtickets.data.core.GroupsContainer;
import com.netcracker.theater.rtickets.data.core.TagInfo;
import com.netcracker.theater.rtickets.data.dao.RepertoireDAO;
import com.netcracker.theater.rtickets.data.entity.*;
import com.netcracker.theater.rtickets.data.service.*;
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
    @Autowired
    UserService userService;
    @Autowired
    RecommendationService recommendationService;

    //Added by Alisa
    @GetMapping("/recommendation")
    public String recommendation(Map<String, Object> model) {
        List<Recommendation> recommendations = recommendationService.getAllRecommendations();
        model.put("recommendations", recommendations);
        Recommendation rec = new Recommendation();
        model.put("rec", rec);
        return "recommendations";
    }
    @GetMapping("/recommendation/NewYear")
    public String recommendationNewYear(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("NewYear");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "NewYear";
    }
    @GetMapping("/recommendation/children")
    public String recommendationChildren(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("children");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "children";
    }


}