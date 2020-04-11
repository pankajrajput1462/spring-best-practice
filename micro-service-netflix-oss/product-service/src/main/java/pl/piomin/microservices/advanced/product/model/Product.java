package pl.piomin.microservices.advanced.product.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

	@Id
	private String productId;
	private int balance;
	private String accountId;
	private String customerId;
	private ProductType type;
	private LocalDate dateOfStart;
	private LocalDate dateOfEnd;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public LocalDate getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(LocalDate dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public LocalDate getDateOfEnd() {
		return dateOfEnd;
	}

	public void setDateOfEnd(LocalDate dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", accountId=" + accountId + ", type=" + type + "]";
	}

}
