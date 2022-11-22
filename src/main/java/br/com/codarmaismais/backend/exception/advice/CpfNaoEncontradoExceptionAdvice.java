package br.com.codarmaismais.backend.exception.advice;

import br.com.codarmaismais.backend.exception.CpfNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CpfNaoEncontradoExceptionAdvice {

    @ExceptionHandler(CpfNaoEncontradoException.class)
    public ResponseEntity handle(CpfNaoEncontradoException exception) {
        return ResponseEntity.badRequest().body( exception.getMessage() );
    }
}
