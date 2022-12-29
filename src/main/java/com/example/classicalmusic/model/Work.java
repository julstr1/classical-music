package com.example.classicalmusic.model;

import javax.persistence.*;

@Entity
@Table(name = "WORKS")
public class Work {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "POPULAR")
    private String popular;

    @Column(name = "RECOMMENDED")
    private String recommended;

    public Work(String title, String genre, String popular, String recommended) {
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

    public String getRecommended() {
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

    public void setRecommended(String recommended) {
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

