package br.com.bootcamp.controller;

import br.com.bootcamp.controller.dto.CategoriaDto;
import br.com.bootcamp.controller.form.CategoriaForm;
import br.com.bootcamp.model.Categoria;
import br.com.bootcamp.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form){
        Categoria categoria = form.converte(categoriaRepository);
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
