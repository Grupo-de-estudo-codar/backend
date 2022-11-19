package br.com.codarmaismais.backend.repository;

import br.com.codarmaismais.backend.model.Cliente;
import br.com.codarmaismais.backend.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    public List<Endereco> findEnderecoByCliente(Cliente cliente);
}
