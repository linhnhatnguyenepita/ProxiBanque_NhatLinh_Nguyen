package com.example.proxibanque.service;

import com.example.proxibanque.entity.Client;
import com.example.proxibanque.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @PostConstruct
    private void initDb() {
        clientRepository.saveAll(
                List.of(
                        new Client(),
                        new Client()
                )
        );
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client coffee) {
        return clientRepository.save(coffee);
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

}
