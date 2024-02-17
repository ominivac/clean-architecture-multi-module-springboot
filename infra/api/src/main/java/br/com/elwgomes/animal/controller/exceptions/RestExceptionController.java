package br.com.elwgomes.animal.controller.exceptions;

import br.com.elwgomes.animal.exceptions.CustomException;
import br.com.elwgomes.animal.exceptions.NameCannotBeNullException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionController extends ResponseEntityExceptionHandler {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class ExceptionResponse {
        private int code;
        private HttpStatus status;
        private String message;
    }

    @ExceptionHandler(NameCannotBeNullException.class)
    public ResponseEntity<ExceptionResponse> NameCannotBeNullHandler (NameCannotBeNullException exception) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> CustomExceptionHandler (CustomException exception) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}