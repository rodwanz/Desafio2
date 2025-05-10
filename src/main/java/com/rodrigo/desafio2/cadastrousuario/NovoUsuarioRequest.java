package com.rodrigo.desafio2.cadastrousuario;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoUsuarioRequest {
    @Email
    @NotBlank
    private String email;
    private @NotBlank @Length(min = 6) String senha;

    public NovoUsuarioRequest(@Email @NotBlank String email, @NotBlank @Length(min = 6) String senha) {
        this.email = email;
        this.senha = senha;
    }
    Usuario toUsuario(){
        return new Usuario(email, new SenhaLimpa(senha));
    }
}
