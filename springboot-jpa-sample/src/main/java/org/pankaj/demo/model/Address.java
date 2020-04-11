package org.pankaj.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Slf4j
@Entity
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "street is mandatory")
    private String street;

    @NotBlank(message = "country is mandatory")
    private String country;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Address address;

}
