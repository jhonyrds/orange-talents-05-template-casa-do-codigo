package br.com.bootcamp.controller.form;

import br.com.bootcamp.model.Autor;
import br.com.bootcamp.model.Categoria;
import br.com.bootcamp.model.Livro;
import br.com.bootcamp.repository.LivroRepository;
import br.com.bootcamp.util.ExisteId;
import br.com.bootcamp.util.UniqueField;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.EntityManager;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class LivroForm {
    @NotBlank
    @UniqueField(entityName = Livro.class, fieldName ="titulo")
    private String titulo;
    @NotBlank @Length(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private Integer numeroDePaginas;
    @NotBlank
    private String isbn;
    @NotBlank
    private String dataPublicacao;
    @NotNull
    @ExisteId(entidade = Categoria.class, atributo = "id")
    private Long idCategoria;
    @NotNull
    @ExisteId(entidade = Autor.class, atributo = "id")
    private Long idAutor;

    public LivroForm(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas,
                     String isbn, String dataPublicacao, Long idCategoria, Long idAutor) {
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

    public Livro converter(EntityManager manager) {
        Categoria categoria = manager.find(Categoria.class, idCategoria);
        Autor autor = manager.find(Autor.class, idAutor);
        return new Livro(titulo, resumo, sumario, preco, numeroDePaginas,isbn, dataPublicacao, categoria, autor);
    }
}
