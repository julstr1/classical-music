package com.example.classicalmusic.controller;

import com.example.classicalmusic.model.Venue;
import com.example.classicalmusic.service.VenuesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/venues")
@Tag(name = "Venues Controller", description = "This REST controller provide services to manage venues in the classical-music application.")
public class VenuesController {
    VenuesService venuesService;

    public VenuesController(VenuesService venuesService) {
        this.venuesService = venuesService;
    }


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides all venues available in the classical-music application.")
    public Iterable<Venue> getAllVenues() {
        return  venuesService.getVenues();
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides venues details for the supplied venue id from the classical-music application.")
    public Venue getVenueById(@PathVariable("id") long venueId) {
        return venuesService.getVenueById(venueId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Creates a new venue in the classical-music application")
    public Venue createVenue(@RequestBody Venue venue) {
        return venuesService.createVenue(venue);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Updates the venue details in the classical-music application for the supplied venue id.")
    public Venue updateVenue(@RequestBody Venue venue, @PathVariable long id) {
        return venuesService.updateVenue(venue, id);
    }


    @PatchMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Updates the venue details in the classical-music application for the supplied venue id.")
    public void updateExistingVenue(@RequestBody Map<String, Object> updates, @PathVariable long id) {
        Venue venue = venuesService.getVenueById(id);
        updates.forEach(
                (update,value) -> {
                    switch (update) {
                        case "name":
                            venue.setName((String) value);
                            break;
                        case "place":
                            venue.setPlace((String) value);
                            break;
                    }
                }
        );
        venuesService.updateVenue(venue, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletes the venue details for the supplied venue id from the classical-music application.")
    public void deleteVenueById(@PathVariable("id") long venueId) {
        venuesService.deleteById(venueId);
    }

}
