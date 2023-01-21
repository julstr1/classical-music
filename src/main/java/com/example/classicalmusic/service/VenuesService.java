package com.example.classicalmusic.service;

import com.example.classicalmusic.model.Venues;
import org.springframework.stereotype.Service;

@Service
public interface VenuesService {

    Venues createVenue(Venues venue);
    Iterable<Venues> getVenues();

    Venues getVenueById(long id);

    Venues updateVenue(Venues venue, long id);

    void deleteById(long id);
    Iterable<Venues> getAllByPlace(String place);
}
