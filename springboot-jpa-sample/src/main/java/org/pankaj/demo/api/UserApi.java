package org.pankaj.demo.api;

import org.pankaj.demo.model.Address;
import org.pankaj.demo.model.User;
import org.pankaj.demo.repo.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserApi {

    private final UserRepository userRepository;

    public UserApi(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{userName}")
    public User showSignUpForm(@PathVariable String userName) {
        return userRepository.findByName(userName);
    }

    @PostMapping("/user")
    public User addUser() {
        final User user = new User();
        user.setEmail("pankaj@gmail.com");
        user.setName("Pankaj");
        List<Address> addressList = new ArrayList<>();
        final Address address1 = new Address();
        address1.setCountry("India");
        address1.setStreet("Awas Vikas");

        final Address address2 = new Address();
        address2.setCountry("India");
        address2.setStreet("Awas Vikas");

        addressList.add(address1);
        addressList.add(address2);
        user.setAddresses(addressList);

        return userRepository.save(user);
    }

}
