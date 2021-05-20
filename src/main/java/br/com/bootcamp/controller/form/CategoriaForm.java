package br.com.bootcamp.controller.form;

import br.com.bootcamp.model.Categoria;
import br.com.bootcamp.repository.CategoriaRepository;
import br.com.bootcamp.util.UniqueField;
import org.hibernate.validator.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank @UniqueField(entityName = Categoria.class, fieldName = "categoria")
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public Categoria converte(CategoriaRepository categoriaRepository) {
        return new Categoria(categoria);
    }
}
