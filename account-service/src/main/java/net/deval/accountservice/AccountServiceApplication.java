package net.deval.accountservice;

import net.deval.accountservice.clients.CustomerRestClient;
import net.deval.accountservice.entities.BankAccount;
import net.deval.accountservice.enums.AccountType;
import net.deval.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository, CustomerRestClient customerRestClient){
        return args -> {
            customerRestClient.allCustomers().forEach(customer -> {
                BankAccount bankAccount1 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MUR")
                        .balance(Math.random()*98675632)
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(customer.getId())
                        .build();
                BankAccount bankAccount2 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MUR")
                        .balance(Math.random()*867543443)
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(customer.getId())
                        .build();
                accountRepository.save(bankAccount1);
                accountRepository.save(bankAccount2);
            });
        };
    }
}
