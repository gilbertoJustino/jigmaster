package com.jigmaster.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    // Construtor que aceita uma mensagem de erro
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Construtor opcional que permite passar a causa raiz
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
