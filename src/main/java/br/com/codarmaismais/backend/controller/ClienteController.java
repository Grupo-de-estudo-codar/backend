package br.com.codarmaismais.backend.controller;

import br.com.codarmaismais.backend.dto.ClienteDto;
import br.com.codarmaismais.backend.dto.ClienteInsertForm;
import br.com.codarmaismais.backend.model.Cliente;
import br.com.codarmaismais.backend.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDto> insert(@RequestBody @Valid ClienteInsertForm clienteInsertForm, UriComponentsBuilder uriBuilder) {
        Cliente cliente = modelMapper.map(clienteInsertForm, Cliente.class);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created( uri ).body( modelMapper.map(cliente, ClienteDto.class) );
    }

//    @PutMapping("{id}")
//    @Transactional
//    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid ClienteUpdateFormDto clienteUpdateFormDto, UriComponentsBuilder uriBuilder) {
//        Cliente cliente = clienteRepository.getReferenceById(id);
//        clienteUpdateFormDto.update( cliente );
//        URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand( cliente.getClienteKey() ).toUri();
//        return ResponseEntity.ok().body( new ClienteDetalhadoDto( cliente ) );
//    }
//
//    @DeleteMapping("{id}")
//    @Transactional
//    public ResponseEntity delete(@PathVariable Integer id) {
//        Cliente cliente = clienteRepository.getReferenceById(id);
//        clienteRepository.delete(cliente);
//        return ResponseEntity.ok(new MensagemDto("Cliente " + cliente.getNome() + " excluído com sucesso"));
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity findById(@PathVariable Integer id) {
//        Cliente cliente = clienteRepository.getReferenceById(id);
//        return ResponseEntity.ok( new ClienteDetalhadoDto( cliente ) );
//    }
//
//    @GetMapping
//    public List<ClienteDetalhadoDto> listAll() {
//        List<Cliente> clientes = clienteRepository.findAll();
//        List<ClienteDetalhadoDto> listaDto = new ArrayList<>();
//
//        clientes.forEach(cliente -> listaDto.add( new ClienteDetalhadoDto(cliente) ));
//        return listaDto;
//    }
}