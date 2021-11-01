package com.netcracker.theater.rtickets.parser;

import com.netcracker.theater.rtickets.NetcrackerTheaterTicketsApplication;
import com.netcracker.theater.rtickets.entity.Theatre;
import com.netcracker.theater.rtickets.service.TheatreService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;


import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {

        ApplicationContext context= SpringApplication.run(NetcrackerTheaterTicketsApplication.class, args);
        TheatreService theatreService = context.getBean(TheatreService.class);

        ArrayList<Theatre> arr = ParserClass.parseTheatre();
        for (Theatre theatre : arr) {
            theatreService.saveTheatre(theatre);
        }
        System.out.println(theatreService.getTheatre(3));
        System.out.println("END!");



        /*
        try {
            FileWriter writer = new FileWriter("C:\\Users\\79501\\Documents\\PROJECT\\Project\\src\\main\\java\\com\\netcracker\\theater\\rtickets\\parser\\tags.txt", true);

            HashSet<String> tags = new HashSet<String>();
            ArrayList<Play> arr = ParserClass.parsePlay();
            for (Play plays : arr) {
                for (String tag : plays.getTags()) {
                    tags.add(tag);
                }
            }
            for (String tag :  tags) {
                writer.append(tag + "\n");
            }
            writer.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }
}
