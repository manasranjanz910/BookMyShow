package dev.manas.BookMyShow.service;

import dev.manas.BookMyShow.model.Show;
import dev.manas.BookMyShow.model.ShowSeat;
import dev.manas.BookMyShow.model.Ticket;
import dev.manas.BookMyShow.model.User;
import dev.manas.BookMyShow.model.constant.ShowSeatStatus;
import dev.manas.BookMyShow.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired//creates an object of repository and inject into TicketService
    private TicketRepository ticketRepository;
    @Autowired
    private ShowSeatService showSeatService;
    @Autowired
    private UserService userService;
    public String greet()
    {
        return "Hello Welcome to Book My Show ";
    }

    public Ticket bookTicket(List<Integer>showSeatIds,int userId) throws Exception
    {
        checkAndLockSeats(showSeatIds);
        makePayment(showSeatIds);
        return new Ticket();

    }

       @Transactional(isolation = Isolation.SERIALIZABLE)
        public void checkAndLockSeats(List<Integer>showSeatIds) throws Exception
        {
            for (int showSeatId : showSeatIds)
            {
                ShowSeat showSeat = showSeatService.findShowSeatById(showSeatId);
                if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                    throw new Exception(("Seat is not Available"));
                }
            }
            for (int showSeatId : showSeatIds)
            {
                ShowSeat showSeat = showSeatService.findShowSeatById(showSeatId);
                showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
                showSeatService.saveShowSeat(showSeat);
            }
        }
        public boolean makePayment(List<Integer>showSeatIds)
        {
           return true;
        }

        public Ticket createTicket(int user_id , int show_id )
        {
              return new Ticket();
        }





}
