package dev.manas.BookMyShow.model;

import dev.manas.BookMyShow.model.constant.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;
    public ShowSeat(){}
    public ShowSeat(Show show, Seat seat, ShowSeatStatus showSeatStatus) {
        this.show = show;
        this.seat = seat;
        this.showSeatStatus = showSeatStatus;
    }

}
