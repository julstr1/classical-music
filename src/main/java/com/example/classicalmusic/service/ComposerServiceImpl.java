package com.example.classicalmusic.service;

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
        return composerRepository.findById(id).get();
    }

    @Override
    public Iterable<Composer> getAllByEpoch(String epoch) {
        return composerRepository.findAllByEpoch(epoch);
    }
}
