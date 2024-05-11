package com.global.BackEnd.security;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDto {
    @NotEmpty
//    @Email        //اشغلها وانا بتيست
    private String userName;

    @NotEmpty
    private String password;
}
