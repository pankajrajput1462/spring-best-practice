package org.pankaj.demo.model.leader;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


import javax.validation.constraints.NotEmpty;

@Data
@Entity(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "Mobile number can't be empty")
    private String mobileNumber;
    private String landLineNumber;
    private String faxNumber;
    @NotEmpty(message = "E-mail can't be empty")
    private String eMail;
}
