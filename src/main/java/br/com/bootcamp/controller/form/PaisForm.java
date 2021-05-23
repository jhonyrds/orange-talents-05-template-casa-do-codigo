package br.com.bootcamp.controller.form;

import br.com.bootcamp.model.Pais;
import br.com.bootcamp.repository.PaisRepository;
import br.com.bootcamp.util.UniqueField;
import org.hibernate.validator.constraints.NotBlank;

public class PaisForm {
    @NotBlank
    @UniqueField(entityName = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais converter(PaisRepository paisRepository) {
        return new Pais(nome);
    }
}
