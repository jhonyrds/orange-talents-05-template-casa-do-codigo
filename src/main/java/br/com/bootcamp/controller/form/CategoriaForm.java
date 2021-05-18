package br.com.bootcamp.controller.form;

import br.com.bootcamp.model.Categoria;
import br.com.bootcamp.repository.CategoriaRepository;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;

public class CategoriaForm {

    @NotBlank
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public Categoria converte(CategoriaRepository categoriaRepository) {
        return new Categoria(categoria);
    }
}
