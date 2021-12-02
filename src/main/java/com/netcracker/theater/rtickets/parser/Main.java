package com.netcracker.theater.rtickets.parser;

import com.netcracker.theater.rtickets.NetcrackerTheaterTicketsApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;


public class Main {


    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(NetcrackerTheaterTicketsApplication.class);
        ParserClass parserClass = context.getBean(ParserClass.class);
        //TESTPARSER testparser = context.getBean(TESTPARSER.class);

        //parserClass.parseTheatre();
        parserClass.parseRecommendation();
        parserClass.parseRepertoire();


        /*
        RecommendationService recommendationService = context.getBean(RecommendationService.class);
        PerfomanceService perfomanceService = context.getBean(PerfomanceService.class);
        CategoryService categoryService = context.getBean(CategoryService.class);
        UserService userService = context.getBean(UserService.class);


        User user = userService.getUser(UUID.fromString("f7083cdf-b5de-4e08-bf29-508d988de50d"));
        System.out.println(userService.getFavoriteCategory(user));
        */





        /*
        Recommendation recommendation = new Recommendation("NewYear", "Новый год");
        recommendation.setPicture(new Picture("/img/NewYear.jpg"));
        recommendationService.saveRecommendation(recommendation);
        recommendation = new Recommendation("classic", "Классика");
        recommendationService.saveRecommendation(recommendation);
        recommendation = new Recommendation("drama", "Драма");
        recommendationService.saveRecommendation(recommendation);
        recommendation = new Recommendation("comedy", "Комедия");
        recommendationService.saveRecommendation(recommendation);
        recommendation = new Recommendation("children", "Детям");
        recommendation.setPicture(new Picture("/img/children.jpg"));
        recommendationService.saveRecommendation(recommendation);
        recommendation = new Recommendation("adult", "Для взрослых");
        recommendationService.saveRecommendation(recommendation);
        recommendation = new Recommendation("balet", "Балет");
        recommendationService.saveRecommendation(recommendation);
        recommendation = new Recommendation("celebration", "Праздник");
        recommendationService.saveRecommendation(recommendation);
        recommendation = new Recommendation("unique", "Уникальный эвент");
        recommendationService.saveRecommendation(recommendation);
        recommendation = new Recommendation("modernArt", "Современное искусство");
        recommendationService.saveRecommendation(recommendation);
        recommendation = new Recommendation("excursion", "Экскурсия");
        recommendationService.saveRecommendation(recommendation);
        recommendation = new Recommendation("music", "Музыка");
        recommendationService.saveRecommendation(recommendation);
        */



        //System.out.println(recommendationService.getRepertoire(recommendationService.getRecommendationByName("NewYear")));

    }
}
