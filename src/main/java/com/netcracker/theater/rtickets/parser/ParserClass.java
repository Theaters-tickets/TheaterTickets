package com.netcracker.theater.rtickets.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.netcracker.theater.rtickets.data.entity.Repertoire;
import com.netcracker.theater.rtickets.data.entity.Theatre;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class ParserClass {

    public static URL url;

    public static ArrayList<Repertoire> parseRepertoire() {
        String pathToTheNextPage = null;
        try {
            url = new URL("https://kudago.com/public-api/v1.4/events/?lang=ru&categories=theater&location=spb&page_size=20&actual_since=1635240332&expand=&fields=id,short_title,description,body_text,age_restriction,tags,images");
            ObjectMapper mapper = new ObjectMapper();
            repertoireArr = new ArrayList<>();
            while (true) {
                JSONObject obj = getObj(url);
                if (obj.isEmpty()) {
                    throw new RuntimeException();
                } else {
                    JSONArray results = (JSONArray) obj.get("results");

                    try {
                        pathToTheNextPage = obj.get("next").toString();
                    } catch (NullPointerException ex) {
                        break;
                    }
                    url = new URL(pathToTheNextPage);

                    for (int i = 0; i < results.size(); i++) {
                        repertoireArr.add(mapper.readValue(results.get(i).toString(), Repertoire.class));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("OK!");
        return repertoireArr;
    }


    /*
    public static ArrayList<Play> parsePlay() {
        String pathToTheNextPage = null;
        try {
            url = new URL("https://kudago.com/public-api/v1.4/events/?lang=ru&categories=theater&location=spb&page_size=20&actual_since=1634365697&expand=&fields=id,title,short_title,place,description,body_text,categories,age_restriction,price,tags,participants,images,dates,is_free");
            ObjectMapper mapper = new ObjectMapper();
            plays = new ArrayList<>();

            while (true) {
                JSONObject obj = getObj(url);
                if (obj.isEmpty()) {
                    throw new RuntimeException();
                } else {
                    JSONArray results = (JSONArray) obj.get("results");
                    try {
                        pathToTheNextPage = obj.get("next").toString();
                    } catch (NullPointerException ex) {
                        break;
                    }
                    url = new URL(pathToTheNextPage);

                    for (int i = 0; i < results.size(); i++) {
                        plays.add(mapper.readValue(results.get(i).toString(), Play.class));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plays;
    } */

    public static ArrayList<Theatre> parseTheatre() {

        String pathToTheNextPage = "";
        try {
            //URL theaterURL = new URL("https://kudago.com/public-api/v1.4/places/?lang=ru&location=spb&categories=theatre&is_closed=0&expand=&page_size=20&fields=id,title,short_title,address,timetable,phone,images,description,body_text,foreign_url,coords,subway");
            URL theaterURL = new URL("https://kudago.com/public-api/v1.4/places/?lang=ru&location=spb&categories=theatre&is_closed=0&expand=&page_size=100&fields=id,title,address,timetable,phone,description,subway,body_text");
            ObjectMapper mapper = new ObjectMapper();
            theatreArr = new ArrayList<>();

            while (true) {
                JSONObject obj = getObj(theaterURL);
                if (obj.isEmpty()) {
                    throw new RuntimeException();
                } else {
                    JSONArray results = (JSONArray) obj.get("results");
                    try {
                        pathToTheNextPage = obj.get("next").toString();
                    } catch (NullPointerException ex) {
                        break;
                    }
                    theaterURL = new URL(pathToTheNextPage);
                    for (int i = 0; i < results.size(); i++) {
                        //theatreService.saveTheatre(mapper.readValue(results.get(i).toString(), Theatre.class));
                        theatreArr.add(mapper.readValue(results.get(i).toString(), Theatre.class));
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("OK!");
        return theatreArr;
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

    public static JSONArray getArray(URL url) {
        JSONArray arr= new JSONArray();
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
                arr = (JSONArray) parse.parse(inline);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }

    public static ArrayList<Theatre> theatreArr;
    public static ArrayList<Repertoire> repertoireArr;
}


