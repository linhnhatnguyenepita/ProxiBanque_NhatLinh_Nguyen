package com.example.proxibanque.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientSummaryDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}