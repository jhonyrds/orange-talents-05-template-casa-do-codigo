package br.com.bootcamp.repository;

import br.com.bootcamp.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    boolean existsByCategoria(String categoria);
}
