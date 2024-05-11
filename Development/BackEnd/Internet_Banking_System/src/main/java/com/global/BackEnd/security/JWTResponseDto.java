package com.global.BackEnd.security;

import com.global.BackEnd.Entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class JWTResponseDto {

    private String accessToken;

    private String refreshToken;
    private User user;

}
