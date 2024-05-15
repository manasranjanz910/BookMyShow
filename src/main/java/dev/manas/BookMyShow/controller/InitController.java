package dev.manas.BookMyShow.controller;

import dev.manas.BookMyShow.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {
    @Autowired
    private InitService initService;

    @GetMapping("/inIt")
    public ResponseEntity getData()
    {
        return ResponseEntity.ok(initService.initialise());
    }
}
