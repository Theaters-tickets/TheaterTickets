package com.netcracker.theater.rtickets.parser;

import com.netcracker.theater.rtickets.NetcrackerTheaterTicketsApplication;
import com.netcracker.theater.rtickets.data.entity.*;
import com.netcracker.theater.rtickets.data.service.*;
import jdk.jfr.consumer.RecordedClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.UUID;


public class Main {


    public static void main(String[] args) {

        ApplicationContext context= SpringApplication.run(NetcrackerTheaterTicketsApplication.class);

        ParserClass parserClass = context.getBean(ParserClass.class);
        //TESTPARSER testparser = context.getBean(TESTPARSER.class);


        //parserClass.parseTheatre();
        parserClass.parseRepertoire();

        /*CategoryService categoryService = context.getBean(CategoryService.class);
        RepertoireService repertoireService = context.getBean(RepertoireService.class);
        testparser.parseRepertoire();
        for (Category cat : categoryService.getAllCategories()) {
            System.out.println(cat.getRepertoires());
        }
        for (Repertoire rep : repertoireService.getAllRepertoire()) {
            System.out.println(rep.getCategories());
        } */

    }
}
