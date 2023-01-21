package com.example.classicalmusic.repository;

import com.example.classicalmusic.model.Work;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface WorkRepository extends CrudRepository<Work, Long> {

    Iterable<Work> findAllByGenre(String genre);

//    boolean existsByName(String name);

    long countByGenre(String genre);
}
