package net.deval.accountservice.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Getter @Setter @ToString
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
