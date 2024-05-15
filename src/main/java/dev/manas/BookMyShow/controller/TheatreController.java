package dev.manas.BookMyShow.controller;

import dev.manas.BookMyShow.dto.TheatreRequestDto;
import dev.manas.BookMyShow.model.Theatre;
import dev.manas.BookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {

    @Autowired
    private TheatreService theatreService;
    @PostMapping("/createTheatre")
    public ResponseEntity createTheatre(@RequestBody TheatreRequestDto theatreRequestDto)
    {
       Theatre theatre = theatreService.createTheatre(theatreRequestDto.getName(),theatreRequestDto.getAddress(),theatreRequestDto.getCityId());
       return ResponseEntity.ok(theatre);
    }
}
