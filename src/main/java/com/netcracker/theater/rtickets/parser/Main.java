package com.netcracker.theater.rtickets.parser;

import com.netcracker.theater.rtickets.NetcrackerTheaterTicketsApplication;
import com.netcracker.theater.rtickets.data.entity.*;
import com.netcracker.theater.rtickets.data.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.Set;
import java.util.UUID;


public class Main {


    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(NetcrackerTheaterTicketsApplication.class);
        ParserClass parserClass = context.getBean(ParserClass.class);
        //TESTPARSER testparser = context.getBean(TESTPARSER.class);

        parserClass.parseRepertoire();

        /*
        //CreateRecommendations createRecommendations = context.getBean(CreateRecommendations.class);
        RecommendationService recommendationService = context.getBean(RecommendationService.class);
        PerfomanceService perfomanceService = context.getBean(PerfomanceService.class);
        CategoryService categoryService = context.getBean(CategoryService.class);
        UserService userService = context.getBean(UserService.class);


        User user = userService.getUser(UUID.fromString("f7083cdf-b5de-4e08-bf29-508d988de50d"));
        System.out.println(userService.getFavoriteCategory(user));





        /*
        Recommendation recommendationNewYear = new Recommendation("NewYear");
        Recommendation recommendationChildren = new Recommendation("children");
        Recommendation recommendation = new Recommendation("default");
        for (Category catg : categoryService.getAllCategories()) {
            if ((catg.getName().equals("рождество")) || (catg.getName().equals("новый год 2022")) || (catg.getName().equals("новогодние ёлки и спектакли"))
                    || (catg.getName().equals("новый год с детьми"))
            ) {
                recommendationNewYear.addCategory(catg);
                recommendationNewYear.setPicture(new Picture("/img/NewYear.jpg"));
                continue;
            }
            if ((catg.getName().equals("детские спектакли")) || (catg.getName().equals("детям")) || (catg.getName().equals("для детей"))
                    || (catg.getName().equals("малыши")) || (catg.getName().equals("выходные с детьми"))
                    || (catg.getName().equals("дошкольники"))|| (catg.getName().equals("школьники"))
                    || (catg.getName().equals("подростки"))|| (catg.getName().equals("всей семьей"))
            ) {
                recommendationChildren.addCategory(catg);
                recommendationChildren.setPicture(new Picture("/img/children.jpg"));
                continue;
            }
            else {
                recommendation.addCategory(catg);
            }

        }
        recommendationService.saveRecommendation(recommendation);
        recommendationService.saveRecommendation(recommendationNewYear);
        recommendationService.saveRecommendation(recommendationChildren);

         */

        //System.out.println(recommendationService.getRepertoire(recommendationService.getRecommendationByName("NewYear")));

    }
}
