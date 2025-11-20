package com.example.proxibanque.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConseillerResponseDTO {
    private Long id;
    private String name;
    private List<ClientSummaryDTO> clients;
}