package com.example.classicalmusic.controller;

import com.example.classicalmusic.model.Performers;
import com.example.classicalmusic.service.PerformersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/performers")
public class PerformersController {
    PerformersService performersService;

    @Autowired

    public PerformersController(PerformersService performersService) {
        this.performersService = performersService;
    }


    @GetMapping
    public Iterable<Performers> getAllPerformers() {
        return  performersService.getPerformers();
    }

    @GetMapping("{id}")
    public Performers getPerformerById(@PathVariable("id") long performerId) {
        return performersService.getPerformerById(performerId);
    }
    @PostMapping
    public Performers createPerformer(@RequestBody Performers performers) {
        return performersService.createPerformer(performers);
    }

    @PutMapping("{id}")
    public Performers updatePerformers(@RequestBody Performers performers, @PathVariable long id) {
        return performersService.updatePerformer(performers, id);
    }


    @PatchMapping("{id}")
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
    public void deletePerformerById(@PathVariable("id") long performerId) {
        performersService.deleteById(performerId);
    }


}
