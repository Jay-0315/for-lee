package com.kakeibo.domain.auth.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//회원가입 요청 DTO
public record RegisterRequest(
    //email address
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    String email,

    //password
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    String password,

    //user name
    @NotBlank(message = "이름을 입력해주세요.")
    @Size(max = 50, message = "이름은 최대 50자까지 입력할 수 있습니다.")
    String name
) {}
