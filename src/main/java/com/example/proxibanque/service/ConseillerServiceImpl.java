package com.example.proxibanque.service;

import com.example.proxibanque.entity.Client;
import com.example.proxibanque.entity.Conseiller;
import com.example.proxibanque.repository.ConseillerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConseillerServiceImpl implements ConseillerService {

    private final ConseillerRepository conseillerRepository;

    @PostConstruct
    private void initDb() {
        Conseiller conseiller1 = new Conseiller("Jean Dupont");

        Conseiller conseiller2 = new Conseiller("Marie Martin");
        Client client = new Client("Pierre", "Durand");
        conseiller2.addClient(client);

        conseillerRepository.saveAll(List.of(conseiller1, conseiller2));
    }

    @Override
    public List<Conseiller> getConseillers() {
        return conseillerRepository.findAll();
    }

    @Override
    public Conseiller save(Conseiller conseiller) {
        // Ensure bidirectional relationship is properly set
        if (conseiller.getClients() != null) {
            conseiller.getClients().forEach(client -> client.setConseiller(conseiller));
        }
        return conseillerRepository.save(conseiller);
    }

    @Override
    public Optional<Conseiller> getConseillerById(Long id) {
        return conseillerRepository.findById(id);
    }

}
