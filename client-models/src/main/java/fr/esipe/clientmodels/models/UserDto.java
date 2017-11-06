package fr.esipe.clientmodels.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author Warren D'ALMEIDA
 */

@Data
@Builder
@ToString
public class UserDto {
	@Pattern(regexp = "[0-9]{1,}")
	private String id;
	private String lastName;
	private String firstName;
	private String street;
	private String city;
	@Pattern(regexp = "[0-9]{5}")
	private String postalCode;
	@Pattern(regexp = "[0-9]{10}")
	private String phone;
	private List<AccountDto> accounts;
}

