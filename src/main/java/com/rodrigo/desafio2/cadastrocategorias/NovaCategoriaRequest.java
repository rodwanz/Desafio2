package com.rodrigo.desafio2.cadastrocategorias;

import com.rodrigo.desafio2.compartilhado.ExistsId;
import com.rodrigo.desafio2.compartilhado.UniqueValue;
import jakarta.persistence.EntityManager;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class NovaCategoriaRequest {
    @NotBlank
    @UniqueValue(domainClass=Categoria.class,fieldName="nome")
    private String nome;
    @Positive
    @ExistsId(domainClass = Categoria.class,fieldName = "id")
    private Long idCategoriaMae;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdCategoriaMae(Long idCategoriaMae){
        this.idCategoriaMae = idCategoriaMae;
    }

    @Override
    public String toString() {
        return "NovaCategoriaRequest{" + "nome='" + nome + '\'' +
                ", idCategoriaMae=" + idCategoriaMae + '}';
    }

    public Categoria toModel(EntityManager manager) {
        Categoria categoria = new Categoria(nome);
        if (idCategoriaMae != null){
            Categoria categoriaMae = manager.find(Categoria.class, idCategoriaMae);
            Assert.notNull(categoriaMae, "O id da categoria tem que ser válido");
            categoriaMae.setMae(categoriaMae);
        }
        return categoria;
    }
}
