package com.example.proxibanque.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private int codePostal;
    private String city;
    private String phoneNumber;
    private Long compteCourantNumber;
    private Long compteEpargneNumber;
    private Long conseillerId;
    private String conseillerName;
}