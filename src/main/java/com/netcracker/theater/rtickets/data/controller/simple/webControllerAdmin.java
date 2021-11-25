package com.netcracker.theater.rtickets.data.controller.simple;


import com.netcracker.theater.rtickets.data.core.GroupsContainer;
import com.netcracker.theater.rtickets.data.core.TagInfo;
import com.netcracker.theater.rtickets.data.dao.RepertoireDAO;
import com.netcracker.theater.rtickets.data.entity.Comment;
import com.netcracker.theater.rtickets.data.entity.Recommendation;
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

    //Page with tags
    @GetMapping("/adminTags")
    public String adminTagsGet(Map<String, Object> model){
        GroupsContainer groupsContainer = new GroupsContainer(categoryService.getAllCategories());
        model.put("groupsContainer", groupsContainer);
        model.put("categoryNames", groupsContainer.getMapContainer().keySet());
        return "tagsOnStart1";
    }
    @PostMapping("/adminTags")
    public String adminTagsPost(
            @RequestBody(required = false) List<TagInfo> TagInfos,
            Map<String, Object> model){
        System.out.println(TagInfos);
        for (TagInfo newTagType : TagInfos){
            categoryService.updateType(newTagType.getTag(), newTagType.getParent());}
        return "tagsOnStart1";
    }


    @GetMapping("/lc")
    public void lc()
    {

    }

}