package com.example.proxibanque.controller;

import com.example.proxibanque.entity.Client;
import com.example.proxibanque.entity.Conseiller;
import com.example.proxibanque.service.ConseillerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class ConseillerController {
    private final ConseillerService conseillerService;

    @GetMapping("conseillers")
    List<Conseiller> getConseillers(){
        return conseillerService.getConseillers();
    }

    @PostMapping("conseillers")
    Conseiller save(@RequestBody Conseiller conseiller){
        return conseillerService.save(conseiller);
    }

    @GetMapping("conseillers/{id}")
    ResponseEntity<Conseiller> getConseiller(@PathVariable Long id){
        return conseillerService.getConseillerById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("conseillers")
    ResponseEntity<Conseiller> update(@RequestBody Conseiller conseiller){
        final Optional<Conseiller> id = conseillerService.getConseillerById(conseiller.getId());
        if(id.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conseillerService.save(conseiller));
    }

    @GetMapping("conseillers/{id}/clients")
    ResponseEntity<Set<Client>> getConseillerWithAllClient(@PathVariable Long id){
        return conseillerService.getConseillerById(id)
                .map(conseiller -> ResponseEntity.ok(conseiller.getClients()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
