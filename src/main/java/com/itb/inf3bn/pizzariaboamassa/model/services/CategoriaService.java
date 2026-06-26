package com.itb.inf3bn.pizzariaboamassa.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itb.inf3bn.pizzariaboamassa.exceptions.NotFound;
import com.itb.inf3bn.pizzariaboamassa.model.entity.Categoria;
import com.itb.inf3bn.pizzariaboamassa.model.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

     // Usando o construtor para injetar a dependência
     
    public CategoriaService (CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Buscar categoria por Id

    public Categoria findById(Long id) {

         try {
            return categoriaRepository.findById(id).get();
         } catch (Exception e) {
            throw new NotFound("Categoria não encontrada com o id: " + id);   
         }
    }

    // Salvar Categoria

    public Categoria save(Categoria categoria) {
        categoria.setCodStatus(true);
        return categoriaRepository.save(categoria);
    }

       // Listando todas as categorias

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    
}
