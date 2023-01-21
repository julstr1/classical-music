package com.example.classicalmusic.repository;

import com.example.classicalmusic.model.Performers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformersRepository extends CrudRepository<Performers, Long> {
    Iterable<Performers> findAllByRole(String role);

}
