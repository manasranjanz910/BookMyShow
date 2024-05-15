package dev.manas.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInRequestDto {
    private String email;
    private String password;
}
