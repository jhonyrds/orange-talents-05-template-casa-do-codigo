package br.com.bootcamp.repository;

import br.com.bootcamp.model.Livro;
import br.com.bootcamp.model.LivroProjecao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<LivroProjecao> findAllBy();
}
