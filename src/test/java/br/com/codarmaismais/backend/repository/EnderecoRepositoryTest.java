package br.com.codarmaismais.backend.repository;

import br.com.codarmaismais.backend.model.Cliente;
import br.com.codarmaismais.backend.model.Contato;
import br.com.codarmaismais.backend.model.Endereco;
import br.com.codarmaismais.backend.model.TipoContato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EnderecoRepositoryTest {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ClienteRepository clienteRepository;
    Cliente cliente = new Cliente("Fulano de Tal");
    Endereco endereco = new Endereco("Rua Nova", "500", "Bairro Qualquer", "Cidade Qualquer", "XX", cliente);

    @BeforeEach
    public void beforeEach() {
        clienteRepository.save( cliente );
        enderecoRepository.save( endereco );
    }

    @Test
    @DisplayName("Deve guardar um endereco no BD")
    public void test1() {
        assertNotNull( endereco.getId() );
    }

    @Test @DisplayName("Deve alterar o logradouro do endereco no BD")
    public void test2() {
        endereco.setLogradouro("Rua Antiga");
        Endereco endereco2 = enderecoRepository.getReferenceById( endereco.getId() );
        assertEquals("Rua Antiga", endereco2.getLogradouro());
    }

    @Test @DisplayName("Deve deletar um endereco do BD")
    public void test3() {
        enderecoRepository.delete( endereco );
        Optional<Endereco> enderecoOpcional = enderecoRepository.findById( endereco.getId() );
        assertFalse( enderecoOpcional.isPresent() );
    }

    @Test @DisplayName("Deve fazer uma busca de endereco por ID no BD")
    public void test4() {
        Optional<Endereco> enderecoOpcional = enderecoRepository.findById( endereco.getId() );
        assertTrue( enderecoOpcional.isPresent() );
    }

    @Test @DisplayName("Deve listar mais de um endereco no BD")
    public void test5() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        assertNotNull( enderecos );
        assertTrue(enderecos.size() > 0);
    }

}