package br.com.codarmaismais.backend.controller;

import br.com.codarmaismais.backend.model.Produto;
import br.com.codarmaismais.backend.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity consultaProdutoIndividual(@PathVariable int id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> consultaListaProdutos(){
        List<Produto> listProduto = produtoRepository.findAll()
                .stream()
                .map(x-> modelMapper.map(x, Produto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listProduto);
    }

    @PostMapping(value = "/novo")
    public ResponseEntity<Object> novoProduto(@RequestBody Produto produto) throws ClassNotFoundException {
        Produto produtoSalvo = produtoRepository.save(produto);
        return ResponseEntity.ok().body(produtoSalvo);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Produto> atualizaProduto(@PathVariable Integer id, @RequestBody Produto produto){
        produto.setId(id);
        Produto newProduto = produtoRepository.save(produto);
        return ResponseEntity.ok().body(modelMapper.map(newProduto, Produto.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Produto> delete(@PathVariable Integer id){
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
