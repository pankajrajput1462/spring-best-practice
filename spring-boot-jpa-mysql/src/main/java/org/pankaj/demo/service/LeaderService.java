package org.pankaj.demo.service;

import org.pankaj.demo.model.leader.Address;
import org.pankaj.demo.model.leader.Contact;
import org.pankaj.demo.model.leader.Leader;
import org.pankaj.demo.repo.LeaderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaderService {

    private final LeaderRepository leaderRepository;

    public LeaderService(LeaderRepository leaderRepository) {
        this.leaderRepository = leaderRepository;
    }

    public List<Leader> getAllLeaderList() {
        return leaderRepository.findAll();
    }

    public Leader saveLeader() {
        Leader leader = new Leader();
        List<Address> addressList = new ArrayList<>();
        Address address1 = new Address();
        address1.setCountry("India");
        address1.setStreet("Whitefield");
        Address address2 = new Address();
        address2.setCountry("India");
        address2.setStreet("Kadughodi");
        addressList.add(address1);
        addressList.add(address2);
        leader.setAddress(addressList);

        List<Contact> contactList = new ArrayList<>();
        final Contact contact1 = new Contact();
        contact1.setEMail("pankajrajput1462@gmail.com");
        contact1.setMobileNumber("976655555");
        contact1.setLandLineNumber("888787");

        contactList.add(contact1);
        leader.setContact(contactList);
        leaderRepository.save(leader);
        return leader;
    }
}
