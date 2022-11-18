package br.com.codarmaismais.backend.repository;

import br.com.codarmaismais.backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
