package com.example.classicalmusic.service;
import com.example.classicalmusic.model.Work;
import org.springframework.stereotype.Service;

@Service
public interface WorkService {
    Work createWork(Work work);
    Iterable<Work> getWorks();

    Work getWorkById(long id);

    Work updateWork(Work work, long id);

    void deleteById(long id);

    Iterable<Work> getAllByGenre(String genre);
}
