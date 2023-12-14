package net.deval.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.deval.accountservice.enums.AccountType;
import net.deval.accountservice.model.Customer;

import java.time.LocalDate;

@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
