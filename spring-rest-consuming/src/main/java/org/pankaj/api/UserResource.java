package org.pankaj.api;

import org.pankaj.model.GreetingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserResource {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/quote")
	public GreetingResponse userQuotes() {
		//Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		GreetingResponse greetingResponse = restTemplate.getForObject("http://localhost:8080/greeting", GreetingResponse.class);
		return greetingResponse;
	}
}
