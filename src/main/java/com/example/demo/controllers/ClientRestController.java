package com.example.demo.controllers;

import com.example.demo.entity.Funcionario;
import com.example.demo.entity.Rol;
import com.example.demo.entity.TipoLista;
import com.example.demo.entity.User;
import com.example.demo.service.ClientService;
import com.example.demo.service.FuncionarioService;
import com.example.demo.service.ListTypeService;
import com.example.demo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
@RefreshScope
public class ClientRestController {

    private final ClientService clientService;
    private final RolService rolService;
    private final ListTypeService typeService;
    private final FuncionarioService funcionarioService;

    @Autowired
    public ClientRestController(ClientService clientService, RolService rolService, ListTypeService typeService, FuncionarioService funcionarioService) {
        this.clientService = clientService;
        this.rolService = rolService;
        this.typeService = typeService;
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> data() throws InterruptedException {
        var data = clientService.list();
        return  new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/list_rol")
    public ResponseEntity<List<Rol>> list_rol() {
        var data = rolService.list();
        return  new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/list_type")
    public ResponseEntity<List<TipoLista>> list(Pageable page){
        var data = this.typeService.list(page);
        return new ResponseEntity<>(data.getContent(), HttpStatus.OK);
    }

    @GetMapping("/list_funcionario")
    public ResponseEntity<List<Funcionario>> list_funcionario(){
        var data = this.funcionarioService.list();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/save-tipolista-list")
    public ResponseEntity<Void> saveTipoListaList() {
        typeService.saveListType();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/save-tipolista-list-one")
    public ResponseEntity<Void> saveTipoListaListOne() {
        typeService.saveListOne();
        return ResponseEntity.ok().build();
    }

}
