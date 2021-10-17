package com.netcracker.theater.rtickets.controller;

import com.netcracker.theater.rtickets.entity.Theatre;
import com.netcracker.theater.rtickets.service.TheatreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Theatre", description = "The Theatre API")
@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private TheatreService theatreService;

    @Operation(summary = "все театры")
    @GetMapping("/theatre")
    public List<Theatre> showAllTheatre()
    {
        return theatreService.getAllTheatre();
    }

    @PostMapping("/theatre")
    public void saveTheatre(@RequestBody Theatre theatre2)
    {
        theatreService.saveTheatre(theatre2);
    }

    @DeleteMapping("/theatre/{id}")
    public void deleteTheatre(@PathVariable int id)
    {
        theatreService.deleteTheatre(id);
    }

    @PutMapping("/theatre")
    public void deleteTheatre(@RequestBody Theatre theatre)
    {
        theatreService.saveTheatre(theatre);
    }

}