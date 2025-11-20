package com.example.proxibanque.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "clients")
@EqualsAndHashCode(exclude = "clients")
public class Conseiller {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "conseiller", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("conseiller")
    private Set<Client> clients = new HashSet<>();

    public void addClient(Client client) {
        if(!clients.contains(client) && clients.size() < 10) {
            clients.add(client);
            client.setConseiller(this);
        }
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public Conseiller(String name) {
        this.name = name;
    }
}
