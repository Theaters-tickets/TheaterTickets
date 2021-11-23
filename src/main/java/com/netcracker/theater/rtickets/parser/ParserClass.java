package com.netcracker.theater.rtickets.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.netcracker.theater.rtickets.data.entity.*;
import com.netcracker.theater.rtickets.data.service.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Configurable
@Component
public class ParserClass {

    @Autowired
    private TheatreService theatreService;
    @Autowired
    private RepertoireService repertoireService;
    @Autowired
    private PerfomanceService perfomanceService;
    @Autowired
    private RoleActorService roleActorService;
    @Autowired
    private ActorService actorService;
    @Autowired
    private CategoryService categoryService;

    private static long CURRENT_TIME = Instant.now().getEpochSecond();
    private boolean check;

    public int countPages = 0;

    public static URL url;

     public void parseRepertoire() {
        String pathToTheNextPage = null;
        Long theatreNumber = 0L;
        try {
            url = new URL("https://kudago.com/public-api/v1.4/events/?lang=ru&categories=theater&location=spb&page_size=20&actual_since=1635240332&expand=&fields=id,short_title,description,body_text,age_restriction,tags,images,dates,place,participants");
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            while (true) {
                JSONObject obj = getObj(url);
                if (obj.isEmpty()) {
                    throw new RuntimeException();
                } else {
                    JSONArray results = (JSONArray) obj.get("results");
                    for (Object result : results) {
                        Repertoire repertoire = mapper.readValue(result.toString(), Repertoire.class);
                        check = true;
                        for (Repertoire rep : repertoireService.getAllRepertoire()) {
                            if (rep.equals(repertoire)) { //check fot unique value
                                repertoire = rep;
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            repertoireService.saveRep(repertoire);
                        }


                        //SAVE THEATRE
                        JSONObject resultObject = (JSONObject)result;
                        try {
                            theatreNumber = (Long) ((JSONObject) resultObject.get("place")).get("id");
                        } catch (Exception ex) {
                            System.out.println("No place for this performance!");
                            continue;
                        }
                        Theatre theatre = theatreService.getTheatreByNumber(theatreNumber);
                        if (theatre  == null) {
                            URL newTheatreUrl = new URL("https://kudago.com/public-api/v1.4/places/" + theatreNumber +"/?lang=&fields=id,title,address,timetable,phone,description,subway,body_text");
                            JSONObject theatreObj = getObj(newTheatreUrl);
                            if (theatreObj.isEmpty()) {
                                throw new RuntimeException();
                            }
                            else {
                                theatreService.saveTheatre(mapper.readValue(theatreObj.toString(), Theatre.class));
                                theatre = theatreService.getTheatreByNumber(theatreNumber);
                            }
                        }


                        //SAVE PARTICIPANTS
                        JSONArray participantsArr = (JSONArray)resultObject.get("participants");
                        Set<Actor> actors = new HashSet<>();
                        for (Object participant : participantsArr) {
                            RoleActor roleActor = roleActorService.getRoleByName(((JSONObject)((JSONObject) participant).get("role")).get("slug").toString());
                            if (roleActor == null) {
                                roleActor = mapper.readValue((((JSONObject) participant).get("role").toString()), RoleActor.class);
                                if (roleActor.getName().equals("stage-theatre")) {
                                    continue; //don't write theatres as role
                                }
                            }
                            Actor actor = mapper.readValue(( ((JSONObject) participant).get("agent").toString()), Actor.class);
                            check = true;
                            for (Actor act : actorService.getAllActors()) {
                                if (act.equals(actor)) { //check fot unique value
                                    actor = act;
                                    check = false;
                                    break;
                                }
                            }
                            if (check) {
                                roleActor.addActor(actor);
                                roleActorService.saveRole(roleActor);
                            }
                            actors.add(actor);
                        }


                        //SAVE PERFORMANCE
                        JSONArray dateArr = (JSONArray)resultObject.get("dates");
                        for (Object date : dateArr) {
                            if ((Long)((JSONObject)date).get("start") > CURRENT_TIME) {
                                Performance performance = mapper.readValue(( (JSONObject) date).toString(), Performance.class);
                                check = true;
                                for (Performance perf : perfomanceService.getAllPerformance()) {
                                    if (performance.equals(perf)) { //check fot unique value
                                        performance = perf;
                                        check = false;
                                        break;
                                    }
                                }
                                if (check) {
                                    performance.setActors(actors);
                                    perfomanceService.savePer(performance);
                                    theatre.addPerformance(performance);
                                    repertoire.addPerformance(performance);
                                }
                            }
                        }
                        theatreService.saveTheatre(theatre);

                        //SAVE TAGS
                        JSONArray tagsArr = (JSONArray)resultObject.get("tags");
                        for (Object tag : tagsArr) {
                            Category category = mapper.readValue("\"" + tag.toString() + "\"", Category.class);
                            check = true;
                            for (Category catg : categoryService.getAllCategories()) {
                                if (catg.equals(category)) { //check fot unique value
                                    repertoire.addCategory(catg);
                                    check = false;
                                    break;
                                }
                            }
                            if (check) {
                                categoryService.saveCategory(category);
                                repertoire.addCategory(category);
                            }
                        }
                        repertoireService.saveRep(repertoire);
                    }

                    try {
                        pathToTheNextPage = obj.get("next").toString();
                        url = new URL(pathToTheNextPage);
                        countPages++;
                        System.out.println("PAGE " + countPages);
                    } catch (NullPointerException ex) {
                        System.out.println("END!");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("OK!");
    }

    public void parseTheatre() {
        String pathToTheNextPage = "";
        try {
            //URL theaterURL = new URL("https://kudago.com/public-api/v1.4/places/?lang=ru&location=spb&categories=theatre&is_closed=0&expand=&page_size=20&fields=id,title,short_title,address,timetable,phone,images,description,body_text,foreign_url,coords,subway");
            URL theaterURL = new URL("https://kudago.com/public-api/v1.4/places/?lang=ru&location=spb&categories=theatre,concert-hall,art-centers,culture&is_closed=0&expand=&page_size=100&fields=id,title,address,timetable,phone,description,subway,body_text");
            ObjectMapper mapper = new ObjectMapper();

            while (true) {
                JSONObject obj = getObj(theaterURL);
                if (obj.isEmpty()) {
                    throw new RuntimeException();
                } else {
                    JSONArray results = (JSONArray) obj.get("results");
                    for (Object theatreObj : results) {
                        Theatre theatre = theatreService.getTheatreByNumber(Long.parseLong( ((JSONObject)theatreObj).get("id").toString() ));
                        if (theatre  == null) {
                            theatreService.saveTheatre(mapper.readValue(theatreObj.toString(), Theatre.class));
                        }
                    }
                    try {
                        pathToTheNextPage = obj.get("next").toString();
                    } catch (NullPointerException ex) {
                        break;
                    }
                    theaterURL = new URL(pathToTheNextPage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("OK!");
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
}


