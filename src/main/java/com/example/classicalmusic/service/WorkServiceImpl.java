package com.example.classicalmusic.service;

import com.example.classicalmusic.exception.ResourceNotFoundException;
import com.example.classicalmusic.model.Venues;
import com.example.classicalmusic.model.Work;
import com.example.classicalmusic.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService {

    WorkRepository workRepository;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    public Work createWork(Work work) {
        return workRepository.save(work);
    }

    @Override
    public Iterable<Work> getWorks() {
        return workRepository.findAll();
    }

    @Override
    public Work getWorkById(long id) {
        return workRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No work with id %s exists.", id)));
    }

    @Override
    public Iterable<Work> getAllByGenre(String genre) {
        return workRepository.findAllByGenre(genre);
    }

    @Override
    public Work updateWork(Work newWork, long id) {
        Work work = workRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No work with id %s exists.", id)));
        work.setGenre(newWork.getGenre());
        work.setPopular(newWork.getPopular());
        work.setRecommended(newWork.getRecommended());
        work.setTitle(newWork.getTitle());
        return workRepository.save(work);
    }

    @Override
    public void deleteById(long id) {
        workRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No work with id %s exists.", id)));
        workRepository.deleteById(id);
    }
}
