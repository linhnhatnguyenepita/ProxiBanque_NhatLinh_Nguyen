package com.example.proxibanque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class CompteEpargne{
    @Id
    @GeneratedValue
    private Long accountNumber;
    private Long balance;
    private Date openingDate;

    public void addBalance(Long balance) {}

    public CompteEpargne(String firstName, String lastName) {}
}
