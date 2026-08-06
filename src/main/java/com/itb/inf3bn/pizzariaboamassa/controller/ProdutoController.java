package com.itb.inf3bn.pizzariaboamassa.controller;


import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itb.inf3bn.pizzariaboamassa.dto.produto.ProdutoRequest;
import com.itb.inf3bn.pizzariaboamassa.exceptions.BadRequest;
import com.itb.inf3bn.pizzariaboamassa.model.entity.Categoria;
import com.itb.inf3bn.pizzariaboamassa.model.entity.Produto;
import com.itb.inf3bn.pizzariaboamassa.model.services.CategoriaService;
import com.itb.inf3bn.pizzariaboamassa.model.services.ProdutoService;

// @Controller:     Utilizado em sistema WEB (Front-End + Back-End) no mesmo projeto
// @RestController: Utilizado exclusivamente em API´s (Back-End) apenas


@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

private final ProdutoService produtoService;
private final CategoriaService categoriaService;

public ProdutoController(ProdutoService produtoService, CategoriaService categoriaService) {
    this.produtoService = produtoService;
    this.categoriaService = categoriaService;
}


@PostMapping
public ResponseEntity<Produto> saveProduto (@RequestBody ProdutoRequest produtoRequest) {

    // Criando o produto
    Produto produto = criarProduto(produtoRequest);

    if(produtoRequest.getCategoriaId() != null) {
        try {
            Categoria categoria = categoriaService.findById(produtoRequest.getCategoriaId());
            produto.setCategoria(categoria);
        } catch (Exception e) {
            throw new BadRequest("Não foi encontrado a categoria com o id " + produtoRequest.getCategoriaId());
        }
    }

    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/api/v1/produtos").toUriString());
    return ResponseEntity.created(uri).body(produtoService.save(produto));
}


// private : Só pode ser utilizado dentro dessa classe

private Produto criarProduto(ProdutoRequest produtoRequest) {

    Produto produto = new Produto();
    produto.setNome(produtoRequest.getNome());
    produto.setDescricao(produtoRequest.getDescricao());
    produto.setTipo(produtoRequest.getTipo());
    produto.setValorVenda(produtoRequest.getValorVenda());
    produto.setValorCompra(produtoRequest.getValorCompra());
    produto.setQuantidadeEstoque(produtoRequest.getQuantidadeEstoque());

    return produto;
}




}
