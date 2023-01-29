package com.example.classicalmusic.controller;

import com.example.classicalmusic.model.Work;
import com.example.classicalmusic.service.WorkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/works")
@Tag(name = "Works Controller", description = "This REST controller provide services to manage works in the classical-music application.")
public class WorkController {
    WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides all works available in the classical-music application.")
    public Iterable<Work> getAllWorks(@AuthenticationPrincipal Jwt jwt) {
        return  workService.getWorks();
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides works details for the supplied work id from the classical-music application.")
    public  Work getWorkById(@PathVariable("id") long workId, @AuthenticationPrincipal Jwt jwt) {
        return workService.getWorkById(workId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Creates a new work in the classical-music application")
    public Work createWork(@RequestBody Work work, @AuthenticationPrincipal Jwt jwt) {
        return workService.createWork(work);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Updates the work details in the classical-music application for the supplied work id.")
    public Work updateWork(@RequestBody Work work, @PathVariable long id, @AuthenticationPrincipal Jwt jwt) {
        return workService.updateWork(work, id);
    }

    @PatchMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Updates the work details in the classical-music application for the supplied work id.")
    public void updateExistingWork(@RequestBody Map<String, Object> updates, @PathVariable long id, @AuthenticationPrincipal Jwt jwt) {
        Work work = workService.getWorkById(id);
        updates.forEach(
                (update,value) -> {
                    switch (update) {
                        case "genre":
                            work.setGenre((String) value);
                            break;
                        case "popular":
                            work.setPopular((String) value);
                            break;
                        case "recommended":
                            work.setRecommended((int) value);
                            break;
                        case "title":
                            work.setTitle((String) value);
                            break;
                    }
                }
        );
        workService.updateWork(work, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletes the work details for the supplied work id from the classical-music application.")
    public void deleteWorkById(@PathVariable("id") long workId, @AuthenticationPrincipal Jwt jwt) {
        workService.deleteById(workId);
    }

}
