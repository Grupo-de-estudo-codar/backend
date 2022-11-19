package br.com.codarmaismais.backend.repository;

import br.com.codarmaismais.backend.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    Cliente cliente = new Cliente("Fulano de Tal");

    @BeforeEach
    public void beforeEach() {
        clienteRepository.save(cliente);
    }

    @Test @DisplayName("Deve guardar um cliente no BD")
    public void test1() {
        assertNotNull( cliente.getId() );
    }

    @Test @DisplayName("Deve alterar o nome do cliente no BD")
    public void test2() {
        cliente.setNome("José Almeida");
        Cliente cliente2 = clienteRepository.getReferenceById( cliente.getId() );
        assertEquals("José Almeida", cliente2.getNome());
    }

    @Test @DisplayName("Deve deletar um cliente do BD")
    public void test3() {
        clienteRepository.delete( cliente );
        Optional<Cliente> clienteOpcional = clienteRepository.findById( cliente.getId() );
        assertFalse( clienteOpcional.isPresent() );
    }

    @Test @DisplayName("Deve fazer uma busca de cliente por ID no BD")
    public void test4() {
        Optional<Cliente> clienteOpcional = clienteRepository.findById( cliente.getId() );
        assertTrue( clienteOpcional.isPresent() );
    }

    @Test @DisplayName("Deve listar mais de um cliente no BD")
    public void test5() {
        List<Cliente> clientes = clienteRepository.findAll();
        assertNotNull( clientes );
        assertTrue(clientes.size() > 0);
    }

}