package dev.manas.BookMyShow.model;

import dev.manas.BookMyShow.model.constant.AuditoriumFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany
    private List<Seat> seats;
    @OneToMany
    private List<Show>shows;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeature>auditoriumFeatures;
    public Auditorium(){}
    public Auditorium(String name, int capacity,List<AuditoriumFeature> auditoriumFeatures)
    {
        this.name = name;
        this.capacity = capacity;
        this.auditoriumFeatures = auditoriumFeatures;
    }
    public Auditorium(String name, int capacity, List<Seat> seats, List<Show> shows, List<AuditoriumFeature> auditoriumFeatures) {
        this.name = name;
        this.capacity = capacity;
        this.seats = seats;
        this.shows = shows;
        this.auditoriumFeatures = auditoriumFeatures;
    }
}
