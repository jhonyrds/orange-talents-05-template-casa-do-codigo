package br.com.bootcamp.controller.dto;

public class EstadoDto {

    private Long id;
    private String nome;
    private Long idPais;

    public EstadoDto(Long id, String nome, Long idPais) {
        this.id = id;
        this.nome = nome;
        this.idPais = idPais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
