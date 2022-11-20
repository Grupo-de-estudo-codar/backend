package br.com.codarmaismais.backend.repository;

import br.com.codarmaismais.backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    public Optional<Cliente> findByCpf(String cpf);

}
