package com.example.classicalmusic.service;

import com.example.classicalmusic.exception.ResourceNotFoundException;
import com.example.classicalmusic.model.Performer;
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
    public Performer createPerformer(Performer performer) {
        return performersRepository.save(performer);
    }

    @Override
    public Iterable<Performer> getPerformers() {
        return performersRepository.findAll();
    }

    @Override
    public Performer getPerformerById(long id) {
        return performersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No performer with id %s exists.", id)));
    }

    @Override
    public Iterable<Performer> getAllByRole(String role) {
        return performersRepository.findAllByRole(role);
    }

    @Override
    public Performer updatePerformer(Performer newPerformer, long id) {
        Performer performer = performersRepository.findById(id)
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
