package com.example.classicalmusic.service;

import com.example.classicalmusic.model.Performer;
import org.springframework.stereotype.Service;

@Service
public interface PerformersService {
    Performer createPerformer(Performer performer);
    Iterable<Performer> getPerformers();

    Performer getPerformerById(long id);

    Performer updatePerformer(Performer performer, long id);

    void deleteById(long id);
    Iterable<Performer> getAllByRole(String role);
}
