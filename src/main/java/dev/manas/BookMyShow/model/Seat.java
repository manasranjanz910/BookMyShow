package dev.manas.BookMyShow.model;

import dev.manas.BookMyShow.model.constant.SeatStatus;
import dev.manas.BookMyShow.model.constant.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private int row;
    private int col;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
    private String seatNumber;
    public Seat(){}
    public Seat(int row, int col, SeatType seatType, SeatStatus seatStatus, String seatNumber) {
        this.row = row;
        this.col = col;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
        this.seatNumber = seatNumber;
    }
}
