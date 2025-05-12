package com.rodrigo.desafio2.cadastrousuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class CadastroUsuarioController {
    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ProibeEmailDuplicadoValidator proibeEmailDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEmailDuplicadoValidator);
    }
    @PostMapping(value = "/usuarios")
    @Transactional
    public String cria(@RequestBody @Valid NovoUsuarioRequest request){
        Usuario novoUsuario = request.toUsuario();
        manager.persist(novoUsuario);
        return novoUsuario.toString();
    }
}
