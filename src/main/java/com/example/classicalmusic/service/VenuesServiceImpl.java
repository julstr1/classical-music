package com.example.classicalmusic.service;

import com.example.classicalmusic.model.Venues;
import com.example.classicalmusic.repository.VenuesRepository;
import org.springframework.stereotype.Service;

@Service
public class VenuesServiceImpl implements VenuesService{
    VenuesRepository venuesRepository;

    public VenuesServiceImpl(VenuesRepository venuesRepository) {
        this.venuesRepository = venuesRepository;
    }

    @Override
    public Venues createVenue(Venues venue) {
        return venuesRepository.save(venue);
    }

    @Override
    public Iterable<Venues> getVenues() {
        return venuesRepository.findAll();
    }

    @Override
    public Venues getVenueById(long id) {
        return venuesRepository.findById(id).get();
    }

    @Override
    public Iterable<Venues> getAllByPlace(String place) {
        return venuesRepository.findAllByPlace(place);
    }

    @Override
    public Venues updateVenue(Venues newVenue, long id) {
        return venuesRepository.findById(id)
                .map(venue -> {
                    venue.setName(newVenue.getName());
                    venue.setPlace(newVenue.getPlace());
                    return venuesRepository.save(venue);
                })
                .orElseGet(() -> {
                    newVenue.setId(id);
                    return venuesRepository.save(newVenue);
                });
    }

    @Override
    public void deleteById(long id) {
        venuesRepository.deleteById(id);
    }
}
