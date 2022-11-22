package br.com.codarmaismais.backend.controller;

import br.com.codarmaismais.backend.dto.ClienteDto;
import br.com.codarmaismais.backend.dto.ClienteForm;
import br.com.codarmaismais.backend.exception.CpfJaCadastradoException;
import br.com.codarmaismais.backend.exception.CpfNaoEncontradoException;
import br.com.codarmaismais.backend.model.Cliente;
import br.com.codarmaismais.backend.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDto> insert(@RequestBody @Valid ClienteForm clienteInsertForm, UriComponentsBuilder uriBuilder) {
        if (clienteInsertForm.getCpf() != null && clienteRepository.findByCpf(clienteInsertForm.getCpf()).isPresent())
            throw new CpfJaCadastradoException("Cliente com CPF " + clienteInsertForm.getCpf() + " já cadastrado");

        Cliente cliente = modelMapper.map(clienteInsertForm, Cliente.class);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created( uri ).body( modelMapper.map(cliente, ClienteDto.class) );
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<ClienteDto> update(@PathVariable Integer id, @RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        modelMapper.map(clienteForm, cliente);
        return ResponseEntity.ok().body( modelMapper.map(cliente, ClienteDto.class) );
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Integer id) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        clienteRepository.delete(cliente);
        return ResponseEntity.ok("Cliente " + cliente.getNome() + " excluído com sucesso");
    }

    @GetMapping("id/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        return ResponseEntity.ok( modelMapper.map(cliente, ClienteDto.class) );
    }

    @GetMapping("cpf/{cpf}")
    public ResponseEntity findByCpf(@PathVariable String cpf) {
        Optional<Cliente> clienteOpcional = clienteRepository.findByCpf(cpf);
        if (!clienteOpcional.isPresent())
            throw new CpfNaoEncontradoException(cpf);

        return ResponseEntity.ok( modelMapper.map(clienteOpcional.get(), ClienteDto.class) );
    }

    @GetMapping
    public List<ClienteDto> listAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDto> clientesDto = new ArrayList<>();

        clientes.forEach(cliente -> clientesDto.add( modelMapper.map(cliente, ClienteDto.class) ));
        return clientesDto;
    }
}