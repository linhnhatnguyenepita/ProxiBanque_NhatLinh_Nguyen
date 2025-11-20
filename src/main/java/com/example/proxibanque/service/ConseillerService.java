package com.example.proxibanque.service;

import com.example.proxibanque.entity.Conseiller;

import java.util.List;
import java.util.Optional;

public interface ConseillerService {
    List<Conseiller> getConseillers();

    Conseiller save(Conseiller conseiller);

    Optional<Conseiller> getConseillerById(Long id);


}
