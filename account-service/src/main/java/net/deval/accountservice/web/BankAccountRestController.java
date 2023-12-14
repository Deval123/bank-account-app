package net.deval.accountservice.web;

import net.deval.accountservice.clients.CustomerRestClient;
import net.deval.accountservice.entities.BankAccount;
import net.deval.accountservice.model.Customer;
import net.deval.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestController {
    private BankAccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public BankAccountRestController(BankAccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        return accountRepository.findAll();
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount = accountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
