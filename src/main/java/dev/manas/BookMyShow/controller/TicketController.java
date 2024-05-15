package dev.manas.BookMyShow.controller;

import dev.manas.BookMyShow.dto.BookTicketRequestDto;
import dev.manas.BookMyShow.dto.TicketRequestDto;
import dev.manas.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/greet")
   public ResponseEntity greetUser()
   {
       String greet = ticketService.greet();
       return ResponseEntity.ok(greet);
   }
   @PostMapping("/book")
   public ResponseEntity bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto) throws Exception {
       return ResponseEntity.ok(ticketService.bookTicket(bookTicketRequestDto.getShowSeatIds(), bookTicketRequestDto.getUserId()));
   }

   @PostMapping("/createTicket")
   public ResponseEntity createTicket(@RequestBody TicketRequestDto ticketRequestDto)
   {
       return ResponseEntity.ok(ticketService.createTicket(ticketRequestDto.getUserid(), ticketRequestDto.getShowid()));
   }


}
