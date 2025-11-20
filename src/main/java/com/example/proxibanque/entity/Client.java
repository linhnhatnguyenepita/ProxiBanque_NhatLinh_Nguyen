package com.example.proxibanque.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "conseiller")
@EqualsAndHashCode(exclude = "conseiller")
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private int codePostal;
    private String city;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "compte_courant_account_number")
    private CompteCourant compteCourant;

    @OneToOne
    @JoinColumn(name = "compte_epargne_account_number")
    private CompteEpargne compteEpargne;

    @ManyToOne
    @JoinColumn(name = "conseiller_id")
    @JsonIgnoreProperties("clients")
    private Conseiller conseiller;

    public Client(String firstName, String lastName, String address, int codePostal, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.codePostal = codePostal;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public Client(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
