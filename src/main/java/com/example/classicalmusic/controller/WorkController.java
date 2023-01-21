package com.example.classicalmusic.controller;

import com.example.classicalmusic.model.Work;
import com.example.classicalmusic.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/works")
public class WorkController {
    WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }


    @GetMapping
    public Iterable<Work> getAllWorks() {
        return  workService.getWorks();
    }

    @GetMapping("{id}")
    public  Work getWorkById(@PathVariable("id") long workId) {
        return workService.getWorkById(workId);
    }
    @PostMapping
    public Work createWork(@RequestBody Work work) {
        return workService.createWork(work);
    }

    @PutMapping("{id}")
    public Work updateWork(@RequestBody Work work, @PathVariable long id) {
        return workService.updateWork(work, id);
    }

    @PatchMapping("{id}")
    public void updateExistingWork(@RequestBody Map<String, Object> updates, @PathVariable long id) {
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
                            work.setRecommended((String) value);
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
    public void deleteWorkById(@PathVariable("id") long workId) {
        workService.deleteById(workId);
    }

}
