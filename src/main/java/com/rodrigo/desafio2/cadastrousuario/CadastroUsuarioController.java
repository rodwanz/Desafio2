package com.rodrigo.desafio2.cadastrousuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.annotation.Persistent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class CadastroUsuarioController {
    @PersistenceContext
    private EntityManager manager;
    @PostMapping(value = "/usuarios")
    @Transactional
    public String cria(@RequestBody @Valid NovoUsuarioRequest request){
        Usuario novoUsuario = request.toUsuario();
        manager.persist(novoUsuario);
        return novoUsuario.toString();
    }
}
