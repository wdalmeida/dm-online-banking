package fr.esipe.clientmanagement.user.controllers;

import fr.esipe.clientmodels.models.AccountDto;
import fr.esipe.clientmodels.models.UserDto;
import fr.esipe.restservices.utils.AccessAdvisor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Warren D'ALMEIDA
 */
@RestController
@RequestMapping(path = "/account")
public class AccountController {

	private AccessAdvisor aa= new AccessAdvisor();

	@RequestMapping(method = RequestMethod.POST) //TODO 
	public ResponseEntity<AccountDto> create(@RequestBody AccountDto account) {
		AccountDto newAccount = aa.addEntity("/account", account, AccountDto.class);
		return new ResponseEntity<>(newAccount,HttpStatus.OK);
	}
}
