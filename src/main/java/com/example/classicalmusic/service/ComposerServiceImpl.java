package com.example.classicalmusic.service;

import com.example.classicalmusic.exception.ResourceNotFoundException;
import com.example.classicalmusic.model.Composer;
import com.example.classicalmusic.repository.ComposerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ComposerServiceImpl implements ComposerService {
    ComposerRepository composerRepository;

    @Autowired
    public ComposerServiceImpl(ComposerRepository composerRepository) {
        this.composerRepository = composerRepository;
    }

    @Override
    public Composer createComposer(Composer composer) {
        return composerRepository.save(composer);
    }

    @Override
    public Iterable<Composer> getComposers() {
        return composerRepository.findAll();
    }

    @Override
    public Composer getComposerById(long id) {
        return composerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No composer with id %s exists.", id)));
    }

    @Override
    public Iterable<Composer> getAllByEpoch(String epoch) {

        return composerRepository.findAllByEpoch(epoch);
    }

    @Override
    public Composer updateComposer(Composer newComposer, long id) {
        Composer composer = composerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No composer with id %s exists.", id)));
        composer.setName(newComposer.getName());
        composer.setCompleteName(newComposer.getCompleteName());
        composer.setBirth(newComposer.getBirth());
        composer.setDeath(newComposer.getDeath());
        composer.setEpoch(newComposer.getEpoch());
        return composerRepository.save(composer);
}

    @Override
    public void deleteById(long id) {
        composerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No composer with id %s exists.", id)));
        composerRepository.deleteById(id);
    }
}
