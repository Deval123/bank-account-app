package net.deval.customerservice;

import net.deval.customerservice.config.GlobalConfig;
import net.deval.customerservice.entities.Customer;
import net.deval.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){//functional interface
        return args -> {
            List<Customer> customerList = List.of(
                    Customer.builder()
                            .firstName("Hassan")
                            .lastName("lastName")
                            .email("hassan@gmail")
                            .build(),
                    Customer.builder()
                            .firstName("Mohamed")
                            .lastName("Elhannaoui")
                            .email("mohamed@gmail")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }

}
