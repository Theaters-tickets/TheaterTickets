package com.netcracker.theater.rtickets.data.controller.rest;

import com.netcracker.theater.rtickets.data.storage.entity.Repertoire;
import com.netcracker.theater.rtickets.data.core.service.RepertoireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Repertoire", description = "The Repertoire API")
@RestController
@RequestMapping("/api3")
public class RestControllerRepertoire {

    @Autowired
    private RepertoireService repertoireService;

    @Operation(summary = "getAllRepertoire")
    @GetMapping("/rep")
    public List<Repertoire> showRep()
    {
        return repertoireService.getAllRepertoire();
    }

    @PostMapping("/rep")
    public void saverep(@RequestBody Repertoire repertoire)
    {
        repertoireService.saveRep(repertoire);
    }

}