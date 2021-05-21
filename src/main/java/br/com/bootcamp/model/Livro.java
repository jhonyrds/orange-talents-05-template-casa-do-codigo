package br.com.bootcamp.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;


@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @Lob
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private Integer numeroDePaginas;
    @NotBlank
    private String isbn;
    @NotBlank
    private String dataPublicacao;
    @NotNull
    @ManyToOne
    private Categoria idCategoria;
    @NotNull
    @ManyToOne
    private Autor idAutor;

    @Deprecated
    public Livro(){}

    public Livro(String titulo, String resumo, String sumario,
                 BigDecimal preco, Integer numeroDePaginas,
                 String isbn, String dataPublicacao,
                 Categoria idCategoria, Autor idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public Autor getIdAutor() {
        return idAutor;
    }
}
