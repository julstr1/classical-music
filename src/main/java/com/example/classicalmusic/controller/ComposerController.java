package com.example.classicalmusic.controller;

import com.example.classicalmusic.model.Composer;
import com.example.classicalmusic.service.ComposerService;
import com.example.classicalmusic.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/composer/")
public class ComposerController {
    ComposerService composerService;

    @Autowired
    public ComposerController(ComposerService composerService) {
        this.composerService = composerService;
    }


    @GetMapping
    public Iterable<Composer> getAllComposers() {
        return  composerService.getComposers();
    }

    @GetMapping("{id}")
    public  Composer getComposerById(@PathVariable("id") long composerId) {
        return composerService.getComposerById(composerId);
    }
    @PostMapping
    public Composer createComposer(@RequestBody Composer composer) {
        return composerService.createComposer(composer);
    }
//
//    @DeleteMapping
//    public Composer deleteComposer(@PathVariable("id"))
}
