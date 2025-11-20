package com.example.proxibanque.controller;

import com.example.proxibanque.dto.ClientSummaryDTO;
import com.example.proxibanque.dto.ConseillerResponseDTO;
import com.example.proxibanque.dto.DTOMapper;
import com.example.proxibanque.entity.Client;
import com.example.proxibanque.entity.Conseiller;
import com.example.proxibanque.service.ConseillerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ConseillerController {
    private final ConseillerService conseillerService;

    @GetMapping("conseillers")
    List<ConseillerResponseDTO> getConseillers(){
        return conseillerService.getConseillers().stream()
                .map(DTOMapper::toConseillerResponseDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("conseillers")
    Conseiller save(@RequestBody Conseiller conseiller){
        return conseillerService.save(conseiller);
    }

    @GetMapping("conseillers/{id}")
    ResponseEntity<ConseillerResponseDTO> getConseiller(@PathVariable Long id){
        return conseillerService.getConseillerById(id)
                .map(DTOMapper::toConseillerResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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
    ResponseEntity<List<ClientSummaryDTO>> getConseillerWithAllClient(@PathVariable Long id){
        return conseillerService.getConseillerById(id)
                .map(conseiller -> ResponseEntity.ok(
                    conseiller.getClients().stream()
                        .map(DTOMapper::toClientSummaryDTO)
                        .collect(Collectors.toList())
                ))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
