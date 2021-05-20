package br.com.bootcamp.controller;

import br.com.bootcamp.controller.dto.AutorDto;
import br.com.bootcamp.controller.form.AutorForm;
import br.com.bootcamp.model.Autor;
import br.com.bootcamp.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form){
        Autor autor = form.converter(autorRepository);
        autorRepository.save(autor);
        return ResponseEntity.ok().build();

    }
}
