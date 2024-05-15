package dev.manas.BookMyShow.controller;

import dev.manas.BookMyShow.dto.UserSignUpRequestDto;
import dev.manas.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSignUpController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDto requestDto) throws Exception {
        //validate the userdata
        if(requestDto.getName() == null || requestDto.getEmail() == null || requestDto.getPassword().isEmpty())
        {
            throw new Exception("mandatory fields can't be blank");
        }
        return ResponseEntity.ok(
                userService.signUp(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword())
        );
    }
}
