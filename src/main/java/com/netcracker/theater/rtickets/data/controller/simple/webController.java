package com.netcracker.theater.rtickets.data.controller.simple;

import com.netcracker.theater.rtickets.data.storage.entity.*;
import com.netcracker.theater.rtickets.data.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.List;

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
    @GetMapping("/recommendation/adult")
    public String recommendationAdult(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("adult");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "adult";
    }
    @GetMapping("/recommendation/ballet")
    public String recommendationBallet(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("ballet");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "ballet";
    }
    @GetMapping("/recommendation/celebration")
    public String recommendationCelebration(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("celebration");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "celebration";
    }
    @GetMapping("/recommendation/classic")
    public String recommendationClassic(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("classic");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "classic";
    }
    @GetMapping("/recommendation/comedy")
    public String recommendationComedy(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("comedy");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "comedy";
    }
    @GetMapping("/recommendation/drama")
    public String recommendationDrama(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("drama");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "drama";
    }
    @GetMapping("/recommendation/excursion")
    public String recommendationExcursion(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("excursion");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "excursion";
    }
    @GetMapping("/recommendation/modernArt")
    public String recommendationModernArt(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("modernArt");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "modernArt";
    }
    @GetMapping("/recommendation/music")
    public String recommendationMusic(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("music");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "music";
    }
    @GetMapping("/recommendation/unique")
    public String recommendationUnique(Map<String, Object> model) {
        Recommendation recommendation = recommendationService.getRecommendationBySlug("unique");
        List<Repertoire> repertoires = recommendationService.getRepertoire(recommendation);
        model.put("repertoires", repertoires);
        Repertoire rep = new Repertoire();
        model.put("rep", rep);
        return "unique";
    }


}