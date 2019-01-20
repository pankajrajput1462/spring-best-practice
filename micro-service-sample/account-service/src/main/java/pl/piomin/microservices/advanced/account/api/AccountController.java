package pl.piomin.microservices.advanced.account.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.piomin.microservices.advanced.account.model.Account;
import pl.piomin.microservices.advanced.account.repository.AccountRepository;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/v1")
public class AccountController {

	@Autowired
	AccountRepository repository;


	@GetMapping(value = "/accounts/{number}")
	public Account findByNumber(@PathVariable("number") String number) {
		log.info(String.format("Account.findByNumber(%s)", number));
		return repository.findByNumber(number);
	}

	@GetMapping(value = "/accounts/customer/{customer}")
	public List<Account> findByCustomer(@PathVariable("customer") String customerId) {
		log.info(String.format("Account.findByCustomer(%s)", customerId));
		return repository.findByCustomerId(customerId);
	}

	@GetMapping(value = "/accounts")
	public List<Account> findAll() {
		log.info("Account.findAll()");
		return repository.findAll();
	}

	@PostMapping(value = "/accounts")
	public Account add(@RequestBody Account account) {
		log.info(String.format("Account.add(%s)", account));
		return repository.save(account);
	}
	
	@PutMapping(value = "/accounts")
	public Account update(@RequestBody Account account) {
		log.info(String.format("Account.update(%s)", account));
		return repository.save(account);
	}

}
