package br.com.codarmaismais.backend.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class ClienteInsertForm {

    @NotBlank @Max(255)
    private String nome;
    @Max(11)
    private String cpf;
    private String dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
