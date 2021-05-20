package br.com.bootcamp.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String categoria;

    @Deprecated
    public Categoria(){}

    public Categoria(String categoria) {

        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }
}
