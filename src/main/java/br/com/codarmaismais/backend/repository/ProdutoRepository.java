package br.com.codarmaismais.backend.repository;

import br.com.codarmaismais.backend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    public Produto findByNome(String nome);


}
