package com.Ducat.SpringFirstProject.DTO;

import java.sql.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDTO {
    private Date exceptionOccureDate;
    private Map<String,String> reason;
    private String statusType;
}
