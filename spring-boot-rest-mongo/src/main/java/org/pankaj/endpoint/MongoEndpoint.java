package org.pankaj.endpoint;

import java.util.List;

import org.pankaj.model.Customer;
import org.pankaj.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoEndpoint {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/getAllCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomerData() {
        List<Customer> findByEmployeeName = customerRepository.findAll();
        return new ResponseEntity<>(findByEmployeeName, HttpStatus.OK);

    }

    @GetMapping(path = "/getAllCustomerByName/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomerDataByName(@PathVariable("firstName") String firstName) {
        List<Customer> findByEmployeeName = customerRepository.findByEmployeeName(firstName);
        return new ResponseEntity<>(findByEmployeeName, HttpStatus.OK);

    }

    @GetMapping(path = "/getAllCustomerByLastName/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomerDataByLastName(@PathVariable("lastName") String lastName) {
        List<Customer> findByEmployeeLastName = customerRepository.findByEmployeeLastName(lastName);
        return new ResponseEntity<>(findByEmployeeLastName, HttpStatus.OK);

    }


    @PostMapping(path = "/saveCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> saveCustomerData(@RequestBody Customer customer) {
        Customer save = customerRepository.save(customer);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteCustomer/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> deleteCustomerData(@PathVariable("firstName") String firstName) {
        List<Customer> findByEmployeeName = customerRepository.findByEmployeeName(firstName);
        Customer customer = findByEmployeeName.stream().findFirst().get();
        customerRepository.delete(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
