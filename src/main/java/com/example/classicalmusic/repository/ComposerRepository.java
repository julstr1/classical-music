package com.example.classicalmusic.repository;

import com.example.classicalmusic.model.Composer;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ComposerRepository extends CrudRepository<Composer, Long> {

    Iterable<Composer> findAllByEpoch(String epoch);

    boolean existsByName(String name);

    long countByEpoch(String epoch);

    Iterable<Composer> findByNameStartsWith(String name);
}
