package com.netcracker.theater.rtickets.parser;

import com.netcracker.theater.rtickets.NetcrackerTheaterTicketsApplication;
import com.netcracker.theater.rtickets.data.entity.Performance;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.UUID;


public class Main {


    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(NetcrackerTheaterTicketsApplication.class);
        ParserClass parserClass = context.getBean(ParserClass.class);
        TESTPARSER testparser = context.getBean(TESTPARSER.class);

        testparser.parseRepertoire();



    }
}
