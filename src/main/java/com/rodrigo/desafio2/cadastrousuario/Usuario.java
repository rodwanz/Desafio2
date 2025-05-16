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
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @Email @NotBlank String email;
    private @NotBlank @Length(min = 6) String senha;

    @PastOrPresent
    private LocalDateTime usuarioCriado;


    @Deprecated
    public Usuario() {}

    public Usuario(@Email @NotBlank String email, SenhaLimpa senhaLimpa) {
        Assert.isTrue(StringUtils.hasLength(email), "Email não pode ser em branco!");
        Assert.notNull(senhaLimpa, "o objeto do tipo senha limpa nao pode ser nulo");
        this.email = email;
        this.senha = senhaLimpa.hash();
        this.usuarioCriado = LocalDateTime.now();
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Usuario usuario = (Usuario) object;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
