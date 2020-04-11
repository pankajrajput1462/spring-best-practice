package pl.piomin.microservices.advanced.transfer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "transfer")
public class Transfer {

	@Id
	private String transferId;
	private String sender;
	private String recipient;
	private int amount;
	private LocalDateTime createAt;

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "Transfer [transferId=" + transferId + ", sender=" + sender + ", recipient=" + recipient + ", amount=" + amount
				+ ", createAt=" + createAt + "]";
	}

}
