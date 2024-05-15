package dev.manas.BookMyShow.model;

import dev.manas.BookMyShow.model.constant.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private LocalDateTime bookingTime;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    public Ticket(){}
    public Ticket(LocalDateTime bookingTime, Show show, List<ShowSeat> showSeats, TicketStatus ticketStatus) {
        this.bookingTime = bookingTime;
        this.show = show;
        this.showSeats = showSeats;
        this.ticketStatus = ticketStatus;
    }
}
