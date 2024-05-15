package dev.manas.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    public Show(){}

    public Show(LocalDateTime startTime, LocalDateTime endTime, List<ShowSeat> showSeats, Movie movie, Auditorium auditorium) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.showSeats = showSeats;
        this.movie = movie;
        this.auditorium = auditorium;
    }
}
