package com.netcracker.theater.rtickets.data.controller.rest;

import com.netcracker.theater.rtickets.data.entity.Theatre;
import com.netcracker.theater.rtickets.data.service.GenresService;
import com.netcracker.theater.rtickets.data.service.TheatreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Theatre", description = "The Theatre API")
@RestController
@RequestMapping("/api")
public class RestControllerTheatre {

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private GenresService genresService;

    @Operation(summary = "все театры")
    @GetMapping("/theatre")
    public List<Theatre> showAllTheatre()
    {
        return theatreService.getAllTheatre();
    }

    @PostMapping("/theatre")
    public void saveTheatre(@RequestBody Theatre theatre)
    {
        theatreService.saveTheatre(theatre);
    }

    @DeleteMapping("/theatre/{id}")
    public void deleteTheatre(@PathVariable UUID id)
    {
        theatreService.deleteTheatre(id);
    }

    @PutMapping("/theatre")
    public void deleteTheatre(@RequestBody Theatre theatre)
    {
        theatreService.saveTheatre(theatre);
    }



}