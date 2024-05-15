package dev.manas.BookMyShow.controller;

import dev.manas.BookMyShow.dto.UserSignInRequestDto;
import dev.manas.BookMyShow.dto.UserSignUpRequestDto;
import dev.manas.BookMyShow.exception.InvalidEmailException;
import dev.manas.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSignInController {
    @Autowired
    private UserService userService;

    @PostMapping("/signIn")
    public ResponseEntity signIn(@RequestBody UserSignInRequestDto requestDto) throws Exception {
        //validate the userdata
        if( requestDto.getEmail().isEmpty() || requestDto.getPassword().isEmpty()||requestDto.getEmail().isBlank()||requestDto.getPassword().isBlank()||requestDto.getEmail() == null || requestDto.getPassword() == null)
        {
            throw new InvalidEmailException("Email cant be blank");
        }
        return ResponseEntity.ok(
                userService.login(requestDto.getEmail(), requestDto.getPassword())
        );
    }
}
