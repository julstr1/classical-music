package com.example.classicalmusic.service;

import com.example.classicalmusic.model.Performers;
import org.springframework.stereotype.Service;

@Service
public interface PerformersService {
    Performers createPerformer(Performers performers);
    Iterable<Performers> getPerformers();

    Performers getPerformerById(long id);

    Performers updatePerformer(Performers performers,  long id);

    void deleteById(long id);
    Iterable<Performers> getAllByRole(String role);
}
