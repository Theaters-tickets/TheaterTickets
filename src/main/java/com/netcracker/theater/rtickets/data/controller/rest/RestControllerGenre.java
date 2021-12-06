package com.netcracker.theater.rtickets.data.controller.rest;

//import com.netcracker.theater.rtickets.data.storage.entity.Genre;
//import com.netcracker.theater.rtickets.data.core.service.GenresService;
import com.netcracker.theater.rtickets.data.core.service.RepertoireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Genres", description = "The Genres API")
@RestController
@RequestMapping("/genres")
public class RestControllerGenre {

    //@Autowired
    //private GenresService genresService;

    @Autowired
    private RepertoireService repertoireService;

    /*
    @Operation(summary = "все жанры")
    @GetMapping()
    public List<Genre> showAllGenres()
    {
        return genresService.getAllGenres();
    }

     */

    /*
    @PostMapping()
    public void saveGenres(@RequestBody Genre genre)
    {
        genresService.saveGenre(genre);
    }

     */


}