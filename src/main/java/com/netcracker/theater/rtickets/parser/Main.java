package com.netcracker.theater.rtickets.parser;

import com.netcracker.theater.rtickets.NetcrackerTheaterTicketsApplication;
import com.netcracker.theater.rtickets.data.core.service.CommentService;
import com.netcracker.theater.rtickets.data.core.service.RepertoireService;
import com.netcracker.theater.rtickets.data.core.service.UserService;
import com.netcracker.theater.rtickets.data.storage.entity.Comment;
import com.netcracker.theater.rtickets.data.storage.entity.Repertoire;
import com.netcracker.theater.rtickets.data.storage.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;


public class Main {


    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(NetcrackerTheaterTicketsApplication.class);
        ParserClass parserClass = context.getBean(ParserClass.class);
        //TESTPARSER testparser = context.getBean(TESTPARSER.class);

        //parserClass.parseTheatre();
        //parserClass.parseRecommendation();
        //parserClass.parseRepertoire();
        UserService userService = context.getBean(UserService.class);
        CommentService commentService = context.getBean(CommentService.class);
        RepertoireService repertoireService = context.getBean(RepertoireService.class);
        Repertoire rep = repertoireService.getAllRepertoire().iterator().next();
        //Comment comment = new Comment("ff", 5);
        //comment.setRepertoire(rep);
       // commentService.saveComment(comment);
       // comment.setUser(userService.getUserByLogin("user"));
       // System.out.println(userService.getUserByLogin("user").getId());
       // commentService.saveComment(comment);
      //  System.out.println(commentService.getAllComments());


        //System.out.println("attended: " + user.getPerformances_attended());
        //System.out.println("planned: " + user.getPerformances_planned());
        //System.out.println(userService.getUsersRecommendations(user));


        /*
        RecommendationService recommendationService = context.getBean(RecommendationService.class);
        PerfomanceService perfomanceService = context.getBean(PerfomanceService.class);
        CategoryService categoryService = context.getBean(CategoryService.class);
        UserService userService = context.getBean(UserService.class);


        User user = userService.getUser(UUID.fromString("f7083cdf-b5de-4e08-bf29-508d988de50d"));
        System.out.println(userService.getFavoriteCategory(user));
        */

        //System.out.println(recommendationService.getRepertoire(recommendationService.getRecommendationByName("NewYear")));

    }
}
