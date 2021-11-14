package com.netcracker.theater.rtickets.data.controller.simple;

import com.netcracker.theater.rtickets.data.dao.RepertoireDAO;
import com.netcracker.theater.rtickets.data.entity.Repertoire;
import com.netcracker.theater.rtickets.data.service.GenresService;
import com.netcracker.theater.rtickets.data.service.PerfomanceService;
import com.netcracker.theater.rtickets.data.service.RepertoireService;
import com.netcracker.theater.rtickets.data.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.List;

@Controller
public class webController {
    @Autowired
    TheatreService theatreService;
    @Autowired
    RepertoireService repertoireService;
    @Autowired
    GenresService genresService;

    @Autowired
    PerfomanceService perfomanceService;


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


    @GetMapping("/theatres")
    public String getAllTheatres(
            Map<String, Object> model) {
        model.put("theatreList", theatreService.getAllTheatre());
        return "allTheatres";
    }

/*
    @PostMapping("/all")
    public String findTheatre(@RequestParam String theatreName, Map<String, Object> model) {
        model.put("theatreList", filter.theatreByName(theatreName));
        return "allTheatres";
    }

 */


    @GetMapping("/mainPage")
    public String mainPage(
            Map<String, Object> model) {
        List<Repertoire> threeRandom = repertoireService.getThreeRandomRepertoire();
        model.put("threeRandomRepertoire", threeRandom);
        return "mainPage";
    }

    /*
    @GetMapping("/repertoire")
    public String getAllPlays(Map<String, Object> model) {
        model.put("plays", repertoireService.getAllRepertoire());
        return "listOfPlays";
    }

     */

    /*
    @PostMapping("/repertoire")
    public String getFiltratedPlays(@RequestParam String desc, @RequestParam String ageString, Map<String, Object> model) {

        model.put("plays", filter.filterRepertoire(ageString, desc));
        return "listOfPlays";
    }

     */



    @GetMapping("/play/{id}")
    String getPlayById(@PathVariable("id") UUID id, Map<String, Object> model) {
        Repertoire repertoire = repertoireService.getById(id);
        model.put("repertoire", repertoire);
        return "repertoireInfo";
    }



    @GetMapping("/search")
    String playSearcherGet(Map<String, Object> model) {
        model.put("plays", repertoireService.getAllRepertoire());
        return "playSearcher";
    }
    @PostMapping("/search")
    String playSearcherPost(@RequestParam (value="date") String date,
                                    @RequestParam (value="name") String name,
                                    @RequestParam (value="description") String description,
                                    @RequestParam (value="age") String age,
                                    Map<String, Object> model){
        age = age == "" ? "99" : age;
        model.put("plays", repertoireService.filterRepertoire(date, description, name, age));
        System.out.println(date + description + name + age);
        System.out.println(repertoireService.filterRepertoire(date, description, name, age).size());
        return "playSearcher";
    }




/*
    @GetMapping("/filter")
    String getAllPlaysWithDateGet(Map<String, Object> model){
        model.put("rep", repertoireService.getAllRepertoire());
        return "filter";
    }


    @PostMapping("/filter")
    String getAllPlaysWithDatesPost(@RequestParam (value="date") String date,
                                    @RequestParam (value="name") String name,
                                    @RequestParam (value="description") String description,
                                    @RequestParam (value="age") String age,
                                    Map<String, Object> model){
        age = age == "" ? "99" : age;
        model.put("rep", repertoireService.filterRepertoire(date, description, name, age));
        System.out.println(date + description + name + age);
        return "filter";
    }

 */


    /*
    @PostMapping("/search")
    String playSearcherPost(@RequestParam String desc, @RequestParam String ageString, Map<String, Object> model) {
        model.put("plays", filter.filterRepertoire(ageString, desc));
        return "playSearcher";
    }

     */
    @GetMapping("/check")
    public String check(){
        return "qwe";
    }
}