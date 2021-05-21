package br.com.bootcamp.controller;

import br.com.bootcamp.controller.dto.LivroDto;
import br.com.bootcamp.controller.form.AutorForm;
import br.com.bootcamp.controller.form.LivroForm;
import br.com.bootcamp.model.Livro;
import br.com.bootcamp.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.validation.Valid;


@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private EntityManager em;

    @PostMapping()
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm form){

        Livro livro = form.converter(em);
        livroRepository.save(livro);

        return ResponseEntity.ok().build();
    }
}
