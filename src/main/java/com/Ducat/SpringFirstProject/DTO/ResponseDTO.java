package com.Ducat.SpringFirstProject.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private String username;
    private String address;
    private boolean saved;
}
