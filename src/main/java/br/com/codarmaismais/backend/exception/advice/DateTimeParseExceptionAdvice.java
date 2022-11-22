package br.com.codarmaismais.backend.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;

@RestControllerAdvice
public class DateTimeParseExceptionAdvice {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity handle(DateTimeParseException exception) {
        String mensagem = exception.getParsedString() + " não respeita o formato esperado (yyyy-MM-dd)";
        return ResponseEntity.badRequest().body( mensagem );
    }

}
