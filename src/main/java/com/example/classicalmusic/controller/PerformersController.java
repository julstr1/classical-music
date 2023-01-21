package com.example.classicalmusic.controller;

import com.example.classicalmusic.model.Performers;
import com.example.classicalmusic.service.PerformersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/performers")
@Tag(name = "Performers Controller", description = "This REST controller provide services to manage performers in the classical-music application.")
public class PerformersController {
    PerformersService performersService;

    @Autowired

    public PerformersController(PerformersService performersService) {
        this.performersService = performersService;
    }


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides all performers available in the classical-music application.")
    public Iterable<Performers> getAllPerformers() {
        return  performersService.getPerformers();
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides performers details for the supplied performer id from the classical-music application.")
    public Performers getPerformerById(@PathVariable("id") long performerId) {
        return performersService.getPerformerById(performerId);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Creates a new performer in the classical-music application")
    public Performers createPerformer(@RequestBody Performers performers) {
        return performersService.createPerformer(performers);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Updates the performer details in the classical-music application for the supplied performer id.")
    public Performers updatePerformers(@RequestBody Performers performers, @PathVariable long id) {
        return performersService.updatePerformer(performers, id);
    }


    @PatchMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Updates the performer details in the classical-music application for the supplied performer id.")
    public void updateExistingPerformer(@RequestBody Map<String, Object> updates, @PathVariable long id) {
        Performers performers = performersService.getPerformerById(id);
        updates.forEach(
                (update,value) -> {
                    switch (update) {
                        case "role":
                            performers.setRole((String) value);
                            break;
                        case "name":
                            performers.setName((String) value);
                            break;
                        case "surname":
                            performers.setSurname((String) value);
                            break;
                    }
                }
        );
        performersService.updatePerformer(performers, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletes the performer details for the supplied performer id from the classical-music application.")
    public void deletePerformerById(@PathVariable("id") long performerId) {
        performersService.deleteById(performerId);
    }


}
