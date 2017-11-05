package fr.esipe.dataaccess.user.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Warren D'ALMEIDA
 */
@Data
@Entity(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;
}