package br.com.bootcamp.controller;

import br.com.bootcamp.controller.dto.LivroDto;
import br.com.bootcamp.controller.form.LivroForm;
import br.com.bootcamp.model.Livro;
import br.com.bootcamp.model.LivroProjecao;
import br.com.bootcamp.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


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

    @GetMapping()
    public ResponseEntity listar(){
        List<LivroProjecao> list = livroRepository.findAllBy();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> detalhar(@PathVariable Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()){
            return ResponseEntity.ok(new LivroDto(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
