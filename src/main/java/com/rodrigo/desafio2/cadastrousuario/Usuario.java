package com.rodrigo.desafio2.cadastrousuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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

    public Usuario(@Email @NotBlank String email, SenhaLimpa senhaLimpa) {
        Assert.isTrue(StringUtils.hasLength(email), "Email não pode ser em branco!");
        Assert.notNull(senhaLimpa, "o objeto do tipo senha limpa nao pode ser nulo");
        this.email = email;
        this.senha = senhaLimpa.hash();
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email='" + email + '\'' + ", senha='" + senha + '\'' + '}';
    }
}
