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
        try {
            URL url = new URL("https://kudago.com/public-api/v1.4/events/?lang=ru&categories=theater&location=spb&page_size=20&actual_since=1634365697&expand=place,location,dates&fields=id");
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
                JSONObject obj = (JSONObject) parse.parse(inline);
                JSONArray results = (JSONArray)obj.get("results");
                String pathToTheNextPage = obj.get("next").toString();
                System.out.println("next page: " + pathToTheNextPage);

                ///////get id vector////////
                ArrayList<String> indexes = new ArrayList<>();
                for(Object o : results) {
                    JSONObject jsonO = (JSONObject) o;
                    indexes.add(jsonO.get("id").toString());
                }


                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Play> plays = new ArrayList<>();

                for (int i = 0; i < indexes.size(); i++) {
                    URL newurl = new URL("https://kudago.com/public-api/v1.4/events/" + indexes.get(i) + "/?lang=&fields=&expand=");
                    plays.add(mapper.readValue(getPlay(newurl), Play.class));
                    System.out.println(plays.get(i));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String getPlay(URL url) {
        String inline = "";
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                Scanner scanner = new Scanner(url.openStream());

                JSONObject myObject;
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();
                //JSONParser parse = new JSONParser();
                //JSONObject obj = (JSONObject) parse.parse(inline);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  inline;
    }

}

