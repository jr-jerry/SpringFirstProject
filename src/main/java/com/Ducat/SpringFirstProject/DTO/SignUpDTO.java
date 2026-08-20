package com.Ducat.SpringFirstProject.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDTO {
   @NotBlank(message = "username is not valid ")
    private String username;
    @NotBlank(message = "password cannot blank ")
    private String password;
    @NotBlank(message = "kahi to rehte hoge ")
    private String address;   
}
