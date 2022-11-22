package br.com.codarmaismais.backend.exception;

public class CpfNaoEncontradoException extends RuntimeException {
    public CpfNaoEncontradoException(String cpf) {
        super("CPF " + cpf + " não encontrado");
    }
}
