package com.example.classicalmusic.repository;

import com.example.classicalmusic.model.Venue;
import org.springframework.data.repository.CrudRepository;

public interface VenuesRepository extends CrudRepository<Venue, Long> {
    Iterable<Venue> findAllByPlace(String place);
}
