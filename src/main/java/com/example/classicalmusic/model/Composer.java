package com.example.classicalmusic.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "COMPOSERS")
public class Composer {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "NAME")
    private String name;

    @NotEmpty
    @Column(name = "COMPLETE_NAME")
    private String completeName;

    @NotEmpty
    @Column(name = "BIRTH")
    private String birth;

    @Column(name = "DEATH")
    private String death;

    @NotEmpty
    @Column(name = "EPOCH")
    private String epoch;

    public Composer() {

    }

    public Composer(String name, String completeName, String birth, String death, String epoch) {
        this.name = name;
        this.completeName = completeName;
        this.birth = birth;
        this.death = death;
        this.epoch = epoch;
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

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Composer)) return false;
        Composer composer = (Composer) o;
        return completeName.equals(composer.completeName) && birth.equals(composer.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(completeName, birth);
    }

    @Override
    public String toString() {
        return "Composer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", completeName='" + completeName + '\'' +
                ", birth='" + birth + '\'' +
                ", death='" + death + '\'' +
                ", epoch='" + epoch + '\'' +
                '}';
    }
}
