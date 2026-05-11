package com.kakeibo.domain.auth.dto;

//로그인 응답 DTO
public record LoginResponse(
    //jwt token
    String accessToken,

    //user name
    String name
) {}
