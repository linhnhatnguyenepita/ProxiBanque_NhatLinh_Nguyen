package com.example.proxibanque.dto;

import com.example.proxibanque.entity.Client;
import com.example.proxibanque.entity.Conseiller;

import java.util.stream.Collectors;

public class DTOMapper {

    public static ClientResponseDTO toClientResponseDTO(Client client) {
        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setAddress(client.getAddress());
        dto.setCodePostal(client.getCodePostal());
        dto.setCity(client.getCity());
        dto.setPhoneNumber(client.getPhoneNumber());

        if (client.getCompteCourant() != null) {
            dto.setCompteCourantNumber(client.getCompteCourant().getAccountNumber());
        }

        if (client.getCompteEpargne() != null) {
            dto.setCompteEpargneNumber(client.getCompteEpargne().getAccountNumber());
        }

        if (client.getConseiller() != null) {
            dto.setConseillerId(client.getConseiller().getId());
            dto.setConseillerName(client.getConseiller().getName());
        }

        return dto;
    }

    public static ClientSummaryDTO toClientSummaryDTO(Client client) {
        return new ClientSummaryDTO(
            client.getId(),
            client.getFirstName(),
            client.getLastName(),
            client.getPhoneNumber()
        );
    }

    public static ConseillerResponseDTO toConseillerResponseDTO(Conseiller conseiller) {
        ConseillerResponseDTO dto = new ConseillerResponseDTO();
        dto.setId(conseiller.getId());
        dto.setName(conseiller.getName());
        dto.setClients(
            conseiller.getClients().stream()
                .map(DTOMapper::toClientSummaryDTO)
                .collect(Collectors.toList())
        );
        return dto;
    }
}