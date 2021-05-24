package br.com.bootcamp.controller;

import br.com.bootcamp.controller.dto.ClienteDto;
import br.com.bootcamp.controller.form.ClienteForm;
import br.com.bootcamp.model.Cliente;
import br.com.bootcamp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;


@RestController
@RequestMapping("/cadastro-cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @PersistenceContext
    private EntityManager em;

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm form){
        Cliente cliente = form.converter(em);
        clienteRepository.save(cliente);
        return ResponseEntity.ok().build();
    }
}
