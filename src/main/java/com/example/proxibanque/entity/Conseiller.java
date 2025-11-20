package com.example.proxibanque.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Conseiller {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "conseiller", cascade = CascadeType.ALL)
    private Set<Client> clients = new HashSet<>();

    public void addClient(Client client) {
        if(!clients.contains(client) && clients.size() < 10) {
            clients.add(client);
        }
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public Conseiller(String name) {
        this.name = name;
    }
}
