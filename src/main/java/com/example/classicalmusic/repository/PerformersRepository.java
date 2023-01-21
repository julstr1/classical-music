package com.example.classicalmusic.repository;

import com.example.classicalmusic.model.Performer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformersRepository extends CrudRepository<Performer, Long> {
    Iterable<Performer> findAllByRole(String role);

}
