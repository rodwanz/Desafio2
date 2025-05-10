package com.rodrigo.desafio2.cadastrousuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @Email @NotBlank String email;
    private @NotBlank @Length(min = 6) String senha;


    @Deprecated
    public Usuario() {}

    public Usuario(@Email @NotBlank String email, @NotBlank @Length(min = 6) String senha) {
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email='" + email + '\'' + ", senha='" + senha + '\'' + '}';
    }
}
