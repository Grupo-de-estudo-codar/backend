package br.com.codarmaismais.backend.exception.advice;

import br.com.codarmaismais.backend.exception.CpfJaCadastradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CpfJaCadastradoExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CpfJaCadastradoException.class)
    public ResponseEntity hanble(CpfJaCadastradoException exception) {
        return ResponseEntity.badRequest().body( exception.getMessage() );
    }

}
