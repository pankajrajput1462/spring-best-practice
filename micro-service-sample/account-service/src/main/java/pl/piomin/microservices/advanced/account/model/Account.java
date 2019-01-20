package pl.piomin.microservices.advanced.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Builder
@Document(collection = "account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	private String id;
	private String number;
	private int balance;
	private String customerId;
}
