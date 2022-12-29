package com.example.classicalmusic.repository;

import com.example.classicalmusic.model.Work;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository {

    Iterable<Work> findAllByGenre(String genre);

    boolean existsByName(String name);

    long countByGenre(String genre);
}
