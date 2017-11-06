package fr.esipe.clientmodels.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Warren D'ALMEIDA
 */
@Data
@Builder
@ToString
public class AccountDto {

	private Long numco;
	private double amount;
	private String type;
	private UserDto user;

	public  Long getNumco() {
		return numco;
	}

	public  void setNumco(Long numco) {
		this.numco = numco;
	}

	public  double getAmount() {
		return amount;
	}

	public  void setAmount(double amount) {
		this.amount = amount;
	}

	public  String getType() {
		return type;
	}

	public  void setType(String type) {
		this.type = type;
	}

	public  UserDto getUser() {
		return user;
	}

	public  void setUser(UserDto user) {
		this.user = user;
	}
}
