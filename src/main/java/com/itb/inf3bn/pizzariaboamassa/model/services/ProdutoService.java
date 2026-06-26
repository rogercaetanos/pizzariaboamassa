package com.itb.inf3bn.pizzariaboamassa.model.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itb.inf3bn.pizzariaboamassa.exceptions.NotFound;
import com.itb.inf3bn.pizzariaboamassa.model.entity.Categoria;
import com.itb.inf3bn.pizzariaboamassa.model.entity.Produto;
import com.itb.inf3bn.pizzariaboamassa.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaService categoriaService;

     // Usando o construtor para injetar a dependência
     
    public ProdutoService (ProdutoRepository produtoRepository, CategoriaService categoriaService) {
        this.produtoRepository = produtoRepository;
        this.categoriaService = categoriaService;
    }

     // Buscar produto por Id

       public Produto findById(Long id) {

         try {
            return produtoRepository.findById(id).get();
         } catch (Exception e) {
            throw new NotFound("Produto não encontrado com o id: " + id);   
         }
    }

    // Salvar produto
    // @Transactional : Aconselhável quando estou alterando (salvar, atualizar ou excluir) dados contidos em mais de uma tabela

    @Transactional
    public Produto save(Produto produto) {
        produto.setCodStatus(true);
        if(produto.getCategoria() != null ) {
          Categoria categoria = categoriaService.findById(produto.getCategoria().getId());
          produto.setCategoria(categoria);
        }
        return produtoRepository.save(produto);
       
    }

    // Listando todos os produtos

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
    

}
