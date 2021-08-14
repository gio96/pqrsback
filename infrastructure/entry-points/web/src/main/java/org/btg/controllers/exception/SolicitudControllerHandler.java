package org.btg.controllers.exception;

import org.btg.usecase.exceptions.SolicitudException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class SolicitudControllerHandler {

    @ExceptionHandler(SolicitudException.class)
    public ResponseEntity<Object> solicitudException(SolicitudException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", exception.getMessage());

        //return new ResponseEntity<>(body, HttpStatus.resolve(exception.getType().getStatus()));
        return new ResponseEntity<>(body, HttpStatus.valueOf(exception.getType().getStatus()));
    }
}
