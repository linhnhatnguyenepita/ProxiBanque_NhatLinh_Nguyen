package com.example.proxibanque.repository;

import com.example.proxibanque.entity.Client;
import com.example.proxibanque.entity.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConseillerRepository extends JpaRepository<Conseiller, Long> {

}
