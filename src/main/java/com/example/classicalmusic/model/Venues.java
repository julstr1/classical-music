package com.example.classicalmusic.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VENUES")
public class Venues {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "place")
    private String place;

    public Venues() {
    }

    public Venues(long id, String name, String place) {
        this.id = id;
        this.name = name;
        this.place = place;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venues)) return false;
        Venues venues = (Venues) o;
        return name.equals(venues.name) && place.equals(venues.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place);
    }

    @Override
    public String toString() {
        return "Venues{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}


