package com.example.classicalmusic.service;

import com.example.classicalmusic.exception.ResourceNotFoundException;
import com.example.classicalmusic.model.Venue;
import com.example.classicalmusic.repository.VenuesRepository;
import org.springframework.stereotype.Service;

@Service
public class VenuesServiceImpl implements VenuesService {
    VenuesRepository venuesRepository;

    public VenuesServiceImpl(VenuesRepository venuesRepository) {
        this.venuesRepository = venuesRepository;
    }

    @Override
    public Venue createVenue(Venue venue) {
        return venuesRepository.save(venue);
    }

    @Override
    public Iterable<Venue> getVenues() {
        return venuesRepository.findAll();
    }

    @Override
    public Venue getVenueById(long id) {
        return venuesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No venue with id %s exists.", id)));
    }

    @Override
    public Iterable<Venue> getAllByPlace(String place) {
        return venuesRepository.findAllByPlace(place);
    }

    @Override
    public Venue updateVenue(Venue newVenue, long id) {
        Venue venue = venuesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No venue with id %s exists.", id)));
        venue.setName(newVenue.getName());
        venue.setPlace(newVenue.getPlace());
        return venuesRepository.save(venue);

    }

    @Override
    public void deleteById(long id) {
        venuesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No venue with id %s exists.", id)));
        venuesRepository.deleteById(id);
    }
}
