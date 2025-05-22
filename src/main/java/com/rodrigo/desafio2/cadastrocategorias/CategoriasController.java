package com.rodrigo.desafio2.cadastrocategorias;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CategoriasController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/categorias")
    @Transactional
    public String cattegorias(@RequestBody @Valid NovaCategoriaRequest request){
        Categoria categoria = request.toModel(manager);
        manager.persist(categoria);
        return categoria.toString();
    }
}
