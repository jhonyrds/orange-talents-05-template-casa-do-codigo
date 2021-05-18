package br.com.bootcamp.controller.dto;

import br.com.bootcamp.model.Autor;

import java.time.OffsetDateTime;


public class AutorDto {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private OffsetDateTime dataCriacao;

    public AutorDto(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataCriacao = autor.getDataCadastro();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }
}
