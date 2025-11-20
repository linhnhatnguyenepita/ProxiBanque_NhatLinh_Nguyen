package com.example.proxibanque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class CompteEpargne{
    @Id
    @GeneratedValue
    private Long accountNumber;
    private Long balance;
    private LocalDate openingDate;

    public CompteEpargne(Long accountNumber, Long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = LocalDate.now();
    }

    public void addBalance(Long balance) {
        this.balance += balance;
    }
}
