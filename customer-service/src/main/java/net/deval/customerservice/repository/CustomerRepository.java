package net.deval.customerservice.repository;

import net.deval.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
