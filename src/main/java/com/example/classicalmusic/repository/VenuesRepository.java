package com.example.classicalmusic.repository;

import com.example.classicalmusic.model.Venues;
import org.springframework.data.repository.CrudRepository;

public interface VenuesRepository extends CrudRepository<Venues, Long> {
    Iterable<Venues> findAllByPlace(String place);
}
