package br.com.bootcamp.controller.form;

import br.com.bootcamp.model.Autor;
import br.com.bootcamp.repository.AutorRepository;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class AutorForm {
    @NotBlank
    private String nome;
    @Email @NotBlank
    private String email;
    @NotBlank @Length(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converter(AutorRepository autorRepository) {

            return new Autor(nome, email, descricao);

    }
}
