package com.netcracker.theater.rtickets.parser;

import com.netcracker.theater.rtickets.NetcrackerTheaterTicketsApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;


public class Main {


    public static void main(String[] args) {
        //System.out.println(Instant.now().getEpochSecond());
        ApplicationContext context= SpringApplication.run(NetcrackerTheaterTicketsApplication.class);
        ParserClass parserClass = context.getBean(ParserClass.class);
        //TESTPARSER testparser = context.getBean(TESTPARSER.class);
        parserClass.parseTheatre();
        parserClass.parseRepertoire();

    }
}
