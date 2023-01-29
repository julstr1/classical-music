package com.example.classicalmusic.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "WORKS")
public class Work {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "TITLE")
    private String title;

    @NotEmpty
    @Column(name = "GENRE")
    private String genre;

    @NotEmpty
    @Column(name = "POPULAR")
    private String popular;

    @NotEmpty
    @Column(name = "RECOMMENDED")
    private int recommended;

    public Work(String title, String genre, String popular, int recommended) {
        this.title = title;
        this.genre = genre;
        this.popular = popular;
        this.recommended = recommended;
    }

    public Work() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPopular() {
        return popular;
    }

    public int getRecommended() {
        return recommended;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPopular(String popular) {
        this.popular = popular;
    }

    public void setRecommended(int recommended) {
        this.recommended = recommended;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", popular='" + popular + '\'' +
                ", recommended='" + recommended + '\'' +
                '}';
    }
}

