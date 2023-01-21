package com.example.classicalmusic.service;

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
        return workRepository.findById(id).get();
    }

    @Override
    public Iterable<Work> getAllByGenre(String genre) {
        return workRepository.findAllByGenre(genre);
    }

    @Override
    public Work updateWork(Work newWork, long id) {
        return workRepository.findById(id)
                .map(work -> {
                    work.setGenre(newWork.getGenre());
                    work.setPopular(newWork.getPopular());
                    work.setRecommended(newWork.getRecommended());
                    work.setTitle(newWork.getTitle());
                    return workRepository.save(work);
                })
                .orElseGet(() -> {
                    newWork.setId(id);
                    return workRepository.save(newWork);
                });
    }

    @Override
    public void deleteById(long id) {
        workRepository.deleteById(id);
    }
}
