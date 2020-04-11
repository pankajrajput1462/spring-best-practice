package org.pankaj.repository;

import java.util.List;

import org.pankaj.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	List<Customer> findByEmployeeName(String employeeName);
	List<Customer> findByEmployeeLastName(String employeeLastName);
}
