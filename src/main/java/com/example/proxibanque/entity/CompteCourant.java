package com.example.proxibanque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class CompteCourant{

    @Id
    @GeneratedValue
    private Long accountNumber;
    private Long balance;
    private LocalDate openingDate;
    private Long DECOUVERTE = 1000L;

    public CompteCourant(Long accountNumber, Long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = LocalDate.now();
    }

    public void reduceBalance(Long amount) {
        if (balance - amount >= -DECOUVERTE) {
            this.balance -= amount;
        }
    }

    public void addBalance(Long balance) {
        this.balance += balance;
    }
}
