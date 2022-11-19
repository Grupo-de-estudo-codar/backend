package br.com.codarmaismais.backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Contato implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TipoContato tipoContato;
    @Column(nullable = false)
    private String codigo;
    @ManyToOne
    private Cliente cliente;

    public Contato() {
    }

    public Contato(TipoContato tipoContato, String codigo, Cliente cliente) {
        this.tipoContato = tipoContato;
        this.codigo = codigo;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
