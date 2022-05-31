package com.example.demo.controllers;

import com.example.demo.entity.Rol;
import com.example.demo.entity.User;
import com.example.demo.service.ClientService;
import com.example.demo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientRestController {

    private final ClientService clientService;
    private final RolService rolService;

    @Autowired
    public ClientRestController(ClientService clientService, RolService rolService) {
        this.clientService = clientService;
        this.rolService = rolService;
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

    @PostMapping("/getUsername/{username}")
    public ResponseEntity user(@PathVariable String username){
        var user = this.clientService.findByUsername(username);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
