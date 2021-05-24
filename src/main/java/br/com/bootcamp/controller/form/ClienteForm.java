package br.com.bootcamp.controller.form;

import br.com.bootcamp.model.Cliente;
import br.com.bootcamp.model.Estado;
import br.com.bootcamp.model.Pais;
import br.com.bootcamp.util.CPFOrCNPJ;
import br.com.bootcamp.util.ExisteId;
import br.com.bootcamp.util.UniqueField;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

public class ClienteForm {
    @Email
    @NotBlank
    @UniqueField(entityName = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @UniqueField(entityName = Cliente.class, fieldName = "documento")
    @CPFOrCNPJ
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull @ExisteId(entidade = Pais.class, atributo = "id")
    private Long idPais;
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteForm() {
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente converter(EntityManager em) {
        Pais pais = em.find(Pais.class, idPais);
        Estado estado = em.find(Estado.class, idEstado);

        return new Cliente(email, nome, sobrenome, documento, endereco, complemento,
                cidade, pais, estado, telefone, cep);
    }
}
