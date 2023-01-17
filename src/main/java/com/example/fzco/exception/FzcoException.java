package com.example.fzco.exception;

import com.example.fzco.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class FzcoException extends Exception{

    public FzcoException() {
        super();
    }

    public FzcoException(String message) {
        super(message);
    }



}
