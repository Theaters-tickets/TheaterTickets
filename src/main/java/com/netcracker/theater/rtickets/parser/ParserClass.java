package com.netcracker.theater.rtickets.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class ParserClass {
    public static void main(String[] args) {
        String pathToTheNextPage = null;

        /////////////////////////////////////
        /////////////Play parser/////////////
        /////////////////////////////////////
        try {
            URL playsURL = new URL("https://kudago.com/public-api/v1.4/events/?lang=ru&categories=theater&location=spb&page_size=20&actual_since=1634365697&expand=&fields=id,title,short_title,place,description,body_text,categories,age_restriction,price,tags,participants,images,dates,is_free");
            JSONObject obj = getObj(playsURL);
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Play> plays = new ArrayList<>();

            while (true) {
                if (obj.isEmpty()) {
                    throw new RuntimeException();
                } else {
                    JSONArray results = (JSONArray) obj.get("results");
                    try {
                        pathToTheNextPage = obj.get("next").toString();
                    } catch (NullPointerException ex) {
                        System.out.println("Size: " + plays.size());
                        System.out.println("End");
                        break;
                    }
                    System.out.println("next page: " + pathToTheNextPage);

                    for (int i = 0; i < results.size(); i++) {
                        plays.add(mapper.readValue(results.get(i).toString(), Play.class));
                        System.out.println(plays.get(i));
                    }
                    playsURL = new URL(pathToTheNextPage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /////////////////////////////////////
        ///////////Theater parser////////////
        /////////////////////////////////////
        try {
            URL theaterURL = new URL("https://kudago.com/public-api/v1.4/places/?lang=ru&location=spb&categories=theatre&is_closed=0&expand=&page_size=20&fields=id,title,short_title,address,timetable,phone,images,description,body_text,foreign_url,coords,subway");

            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Theater> theaters = new ArrayList<>();

            while (true) {
                JSONObject obj = getObj(theaterURL);
                if (obj.isEmpty()) {
                    throw new RuntimeException();
                } else {
                    JSONArray results = (JSONArray) obj.get("results");
                    try {
                        pathToTheNextPage = obj.get("next").toString();
                    } catch (NullPointerException ex) {
                        System.out.println("Size: " + theaters.size());
                        System.out.println("End");
                        break;
                    }
                    System.out.println("next page: " + pathToTheNextPage);

                    for (int i = 0; i < results.size(); i++) {
                        theaters.add(mapper.readValue(results.get(i).toString(), Theater.class));
                        System.out.println(theaters.get(i));
                    }
                    theaterURL = new URL(pathToTheNextPage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static JSONObject getObj(URL url) {
        JSONObject obj = new JSONObject();
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());
                JSONObject myObject;
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();
                JSONParser parse = new JSONParser();
                obj = (JSONObject) parse.parse(inline);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return obj;
    }
}

