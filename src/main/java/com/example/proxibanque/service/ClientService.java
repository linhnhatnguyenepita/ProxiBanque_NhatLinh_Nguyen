package com.example.proxibanque.service;

import com.example.proxibanque.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getClients();

    Client save(Client client);

    Optional<Client> getClientById(Long id);
}
