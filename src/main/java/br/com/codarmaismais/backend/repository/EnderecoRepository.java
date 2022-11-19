package br.com.codarmaismais.backend.repository;

import br.com.codarmaismais.backend.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
