package com.Ducat.SpringFirstProject.Exception;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Ducat.SpringFirstProject.DTO.ExceptionResponseDTO;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        System.out.println("exception object "+e);
        HashMap<String,String> err=new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error)->{
            String field=((FieldError)error).getField();
            String message=error.getDefaultMessage();
            err.put(field,message);
            });
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
            new Date(System.currentTimeMillis()),err , "BAD_Request"
        );
        return ResponseEntity
                            .status(HttpStatus.BAD_REQUEST)
                            .body(exceptionResponseDTO );
    }

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<ExceptionResponseDTO> handleDuplicateUserException(DuplicateUserException e){
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(new Date(System.currentTimeMillis()),Map.of("message",e.getMessage()), "Conflict ");

        return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(exceptionResponseDTO);

    }
    
}
