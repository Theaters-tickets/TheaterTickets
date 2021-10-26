package com.netcracker.theater.rtickets.parser;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        ArrayList<Play> arr = TESTPARSER.parsePlay();
        for (Play plays : arr) {
            System.out.println(plays);
        }
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
