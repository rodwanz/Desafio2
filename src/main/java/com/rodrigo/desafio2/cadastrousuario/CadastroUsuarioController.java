package com.rodrigo.desafio2.cadastrousuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class CadastroUsuarioController {
    @PostMapping
    public void cria(@RequestBody @Valid NovoUsuarioRequest request){

    }
}
