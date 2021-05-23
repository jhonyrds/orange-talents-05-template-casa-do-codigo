package br.com.bootcamp.controller.form;


import br.com.bootcamp.model.Estado;
import br.com.bootcamp.model.Pais;
import br.com.bootcamp.util.ExisteId;
import br.com.bootcamp.util.UniqueField;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

public class EstadoForm {
    @NotBlank
    @UniqueField(entityName = Estado.class, fieldName = "nome")
    private String nome;
    @NotNull
    @ExisteId(entidade = Pais.class, atributo = "id")
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Estado converter(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        return new Estado(nome, pais);
    }
}
