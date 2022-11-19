package br.com.codarmaismais.backend.repository;

import br.com.codarmaismais.backend.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
