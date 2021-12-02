package com.netcracker.theater.rtickets.data.controller.simple;


import com.netcracker.theater.rtickets.data.core.TagInfo;
import com.netcracker.theater.rtickets.data.storage.entity.*;
import com.netcracker.theater.rtickets.data.core.service.*;
import com.netcracker.theater.rtickets.parser.ParserClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.List;

@Controller
public class webControllerAdmin {
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
    RecommendationService recommendationService;
    @Autowired
    ParserClass parserClass;

    //Page with tags
    @GetMapping("/adminTags")
    public String adminTagsGet(Map<String, Object> model){
        List<Recommendation> groupsContainer = recommendationService.getAllRecommendations();
        //GroupsContainer groupsContainer = new GroupsContainer(categoryService.getAllCategories());
        model.put("groupsContainer", groupsContainer);
        model.put("categoryNames", recommendationService.getAllNames());
        Recommendation rec = new Recommendation();
        model.put("rec", rec);
        Category tag = new Category();
        model.put("tag", tag);
        //model.put("categoryNames", groupsContainer.getMapContainer().keySet());
        return "tagsOnStart1";
    }
    @PostMapping("/adminTags")
    public String adminTagsPost(
            @RequestBody(required = false) List<TagInfo> TagInfos,
            Map<String, Object> model){
        System.out.println(TagInfos);
        for (TagInfo newTagType : TagInfos) {
            Recommendation rec = recommendationService.getRecommendationByName(newTagType.getParent());
            rec.addCategory(categoryService.getCategoryByName(newTagType.getTag()));
            recommendationService.saveRecommendation(rec);
            //categoryService.updateType(newTagType.getTag(), newTagType.getParent());
        }
        return "redirect:/adminTags";
    }


    @GetMapping("/lc")
    public void lc()
    {

    }


    @GetMapping("/status")
    public String statusInfo(Map<String, Object> model){
        model.put("repertoire", repertoireService.getAllRepertoire());
        model.put("theatre", theatreService.getAllTheatre());
        model.put("category", categoryService.getAllCategories());
        model.put("uncategorizedCategory", categoryService.getUncategorizedCategories());
        return "status";
    }

    @PostMapping("/status")
    public String startParser(@RequestParam("parserType") String parserType,
                              Map<String, Object> model){
        model.put("repertoire", repertoireService.getAllRepertoire());
        model.put("theatre", theatreService.getAllTheatre());
        model.put("category", categoryService.getAllCategories());
        model.put("uncategorizedCategory", categoryService.getUncategorizedCategories());
        if (parserType.equals("repertoire")){
            parserClass.parseRepertoire();
            //parserClass.parseRecommendation();
        }
        if (parserType.equals("theatre")){
            parserClass.parseTheatre();
        }
        if (parserType.equals("recommendation")){
            parserClass.parseRecommendation();
        }
        return "status";
    }

}