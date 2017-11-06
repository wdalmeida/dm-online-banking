package fr.esipe.dataaccess.user.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Warren D'ALMEIDA
 */
@Data
@Entity(name = "account")
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numco;

	@Column(name = "amount")
	private double amount;

	@Column(name = "type")
	private String type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "id_user")
	private UserEntity user;

	public Long getNumco() {
		return numco;
	}

	public void setNumco(Long numco) {
		this.numco = numco;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}