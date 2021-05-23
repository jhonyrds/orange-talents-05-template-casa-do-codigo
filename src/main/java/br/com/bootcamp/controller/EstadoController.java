package br.com.bootcamp.controller;

import br.com.bootcamp.controller.dto.EstadoDto;
import br.com.bootcamp.controller.form.EstadoForm;
import br.com.bootcamp.model.Estado;
import br.com.bootcamp.model.Pais;
import br.com.bootcamp.repository.EstadoRepository;
import br.com.bootcamp.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estado")
public class EstadoController {
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private EntityManager em;

    @PostMapping
    public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm form) {
        Estado estado = form.converter(em);
        estadoRepository.save(estado);
            return ResponseEntity.ok().build();
        }
    }


