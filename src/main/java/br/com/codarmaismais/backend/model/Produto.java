package br.com.codarmaismais.backend.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column
    private String nome;

    @Column
    private String descricao;

    @NotNull
    @Column
    private Double preco;

    //@OneToMany(mappedBy = "produto")
    //private Fornecedor fornecedor;

}

