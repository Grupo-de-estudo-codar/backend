package br.com.codarmaismais.backend.exception;

public class CpfJaCadastradoException extends RuntimeException {
    public CpfJaCadastradoException(String menssagem) {
        super(menssagem);
    }
}
