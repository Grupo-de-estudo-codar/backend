package br.com.codarmaismais.backend.repository;

import br.com.codarmaismais.backend.model.Cliente;
import br.com.codarmaismais.backend.model.Contato;
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
class ContatoRepositoryTest {

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    ClienteRepository clienteRepository;
    Cliente cliente = new Cliente("Fulano de Tal");
    Contato contato = new Contato(TipoContato.TELEFONE, "559912345678", cliente);

    @BeforeEach
    public void beforeEach() {
        clienteRepository.save( cliente );
        contatoRepository.save(contato);
    }

    @Test
    @DisplayName("Deve guardar um contato no BD")
    public void test1() {
        assertNotNull( cliente.getId() );
    }

    @Test @DisplayName("Deve alterar o código do contato no BD")
    public void test2() {
        contato.setCodigo("550087654321");
        Contato contato2 = contatoRepository.getReferenceById( contato.getId() );
        assertEquals("550087654321", contato2.getCodigo());
    }

    @Test @DisplayName("Deve deletar um contato do BD")
    public void test3() {
        contatoRepository.delete( contato );
        Optional<Contato> contatoOpcional = contatoRepository.findById( contato.getId() );
        assertFalse( contatoOpcional.isPresent() );
    }

    @Test @DisplayName("Deve fazer uma busca de contato por ID no BD")
    public void test4() {
        Optional<Contato> contatoOpcional = contatoRepository.findById( contato.getId() );
        assertTrue( contatoOpcional.isPresent() );
    }

    @Test @DisplayName("Deve listar mais de um cliente no BD")
    public void test5() {
        List<Contato> contatos = contatoRepository.findAll();
        assertNotNull( contatos );
        assertTrue(contatos.size() > 0);
    }

}