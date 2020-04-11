package org.pankaj.demo.model.leader;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
