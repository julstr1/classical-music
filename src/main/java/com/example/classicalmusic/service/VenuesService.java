package com.example.classicalmusic.service;

import com.example.classicalmusic.model.Venue;
import org.springframework.stereotype.Service;

@Service
public interface VenuesService {

    Venue createVenue(Venue venue);
    Iterable<Venue> getVenues();

    Venue getVenueById(long id);

    Venue updateVenue(Venue venue, long id);

    void deleteById(long id);
    Iterable<Venue> getAllByPlace(String place);
}
