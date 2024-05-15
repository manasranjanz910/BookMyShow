package dev.manas.BookMyShow.service;

import dev.manas.BookMyShow.model.Seat;
import dev.manas.BookMyShow.repository.SeatRepository;
import dev.manas.BookMyShow.repository.ShowSeatRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    private SeatRepository seatRepository;

    public Seat saveSeat(Seat seat)
    {
        return seatRepository.save(seat);
    }
    public Seat findSeatByID(int seatId)
    {
        return seatRepository.findById(seatId).get();
    }
}
