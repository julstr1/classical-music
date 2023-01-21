package com.example.classicalmusic.service;

import com.example.classicalmusic.exception.ResourceNotFoundException;
import com.example.classicalmusic.model.Performers;
import com.example.classicalmusic.repository.PerformersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformersServiceImpl implements PerformersService {
    PerformersRepository performersRepository;

    @Autowired
    public PerformersServiceImpl(PerformersRepository performersRepository) {
        this.performersRepository = performersRepository;
    }

    @Override
    public Performers createPerformer(Performers performers) {
        return performersRepository.save(performers);
    }

    @Override
    public Iterable<Performers> getPerformers() {
        return performersRepository.findAll();
    }

    @Override
    public Performers getPerformerById(long id) {
        return performersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No performer with id %s exists.", id)));
    }

    @Override
    public Iterable<Performers> getAllByRole(String role) {
        return performersRepository.findAllByRole(role);
    }

    @Override
    public Performers updatePerformer(Performers newPerformer, long id) {
        Performers performer = performersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No performer with id %s exists.", id)));
        performer.setRole(newPerformer.getRole());
        performer.setName(newPerformer.getName());
        performer.setSurname(newPerformer.getSurname());
        return performersRepository.save(performer);
    }

    @Override
    public void deleteById(long id) {
        performersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No performer with id %s exists.", id)));
        performersRepository.deleteById(id);
    }
}
