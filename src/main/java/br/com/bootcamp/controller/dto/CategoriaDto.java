package br.com.bootcamp.controller.dto;

import br.com.bootcamp.model.Categoria;

import javax.persistence.Column;

public class CategoriaDto {

    private Long id;

    private String categoria;

    public CategoriaDto(Categoria categoria){
        this.id = categoria.getId();
        this.categoria = categoria.getCategoria();
    }

    public Long getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }
}
