package com.example.classicalmusic.controller;

import com.example.classicalmusic.model.Venues;
import com.example.classicalmusic.service.VenuesService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/venues")
public class VenuesController {
    VenuesService venuesService;

    public VenuesController(VenuesService venuesService) {
        this.venuesService = venuesService;
    }


    @GetMapping
    public Iterable<Venues> getAllVenues() {
        return  venuesService.getVenues();
    }

    @GetMapping("{id}")
    public  Venues getVenueById(@PathVariable("id") long venueId) {
        return venuesService.getVenueById(venueId);
    }
    @PostMapping
    public Venues createVenue(@RequestBody Venues venue) {
        return venuesService.createVenue(venue);
    }

    @PutMapping("{id}")
    public Venues updateVenue(@RequestBody Venues venue, @PathVariable long id) {
        return venuesService.updateVenue(venue, id);
    }


    @PatchMapping("{id}")
    public void updateExistingVenue(@RequestBody Map<String, Object> updates, @PathVariable long id) {
        Venues venues = venuesService.getVenueById(id);
        updates.forEach(
                (update,value) -> {
                    switch (update) {
                        case "name":
                            venues.setName((String) value);
                            break;
                        case "place":
                            venues.setPlace((String) value);
                            break;
                    }
                }
        );
        venuesService.updateVenue(venues, id);
    }

    @DeleteMapping("{id}")
    public void deleteVenueById(@PathVariable("id") long venueId) {
        venuesService.deleteById(venueId);
    }

}
