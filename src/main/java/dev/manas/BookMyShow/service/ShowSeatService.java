package dev.manas.BookMyShow.service;

import dev.manas.BookMyShow.model.ShowSeat;
import dev.manas.BookMyShow.model.constant.ShowSeatStatus;
import dev.manas.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat saveShowSeat(ShowSeat showSeat)
    {
        return showSeatRepository.save(showSeat);
    }
    public ShowSeat findShowSeatById(int showSeatId)
    {
            ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
            return showSeat;
    }


}
