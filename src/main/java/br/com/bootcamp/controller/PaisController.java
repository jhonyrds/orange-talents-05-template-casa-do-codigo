package br.com.bootcamp.controller;

import br.com.bootcamp.controller.dto.PaisDto;
import br.com.bootcamp.controller.form.PaisForm;
import br.com.bootcamp.model.Pais;
import br.com.bootcamp.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<PaisDto> cadastrar(@RequestBody @Valid PaisForm form){
        Pais pais = form.converter(paisRepository);
        paisRepository.save(pais);
        return ResponseEntity.ok().build();
    }
}
