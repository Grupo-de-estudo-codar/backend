package br.com.codarmaismais.backend.repository;

import br.com.codarmaismais.backend.model.Cliente;
import br.com.codarmaismais.backend.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    public List<Contato> findContatoByCliente(Cliente cliente);

}
