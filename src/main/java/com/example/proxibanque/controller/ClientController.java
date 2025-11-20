package com.example.proxibanque.controller;

import com.example.proxibanque.entity.Client;
import com.example.proxibanque.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("clients")
    List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping("clients")
    Client save(@RequestBody Client client){
        return clientService.save(client);
    }

    @GetMapping("clients/{id}")
    ResponseEntity<Client> getClient(@PathVariable Long id){
        return clientService.getClientById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("clients")
    ResponseEntity<Client> update(@RequestBody Client client){
        final Optional<Client> id = clientService.getClientById(client.getId());
        if(id.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientService.save(client));
    }
}
