package org.pankaj.demo.model.leader;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "leader")
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long leaderId;
    private String leaderName;
    private String country;

    @OneToMany(targetEntity = Contact.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_fk", referencedColumnName = "leaderId")
    private List<Contact> contact;

    @JoinColumn(name = "address_fk", referencedColumnName = "leaderId")
    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    private List<Address> address;
}
