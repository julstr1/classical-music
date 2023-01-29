package com.example.classicalmusic.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "PERFORMERS")
public class Performer {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "NAME")
    private String name;

    @NotEmpty
    @Column(name = "SURNAME")
    private String surname;

    @NotEmpty
    @Column(name = "ROLE")
    private String role;

    public Performer() {

    }

    public Performer(long id, String name, String surname, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Performer)) return false;
        Performer performer = (Performer) o;
        return name.equals(performer.name) && surname.equals(performer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Performers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
