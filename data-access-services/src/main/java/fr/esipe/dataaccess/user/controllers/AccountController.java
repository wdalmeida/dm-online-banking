package fr.esipe.dataaccess.user.controllers;

import fr.esipe.clientmodels.models.AccountDto;
import fr.esipe.dataaccess.user.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// import org.springframework.data.domain.PageRequest;

/**
 * @author Warren D'ALMEIDA
 */
@RestController
@RequestMapping(path = "/account")
public class AccountController {

	private final Logger logger = LoggerFactory.getLogger(AccountController.class);

	private final AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * Send a new account into the database
	 *
	 * @param account AccountDto
	 * @return AccountDto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AccountDto> create(@RequestBody AccountDto account) {
		logger.debug("Adding account :"+account.toString());
		return new ResponseEntity<>(accountService.create(account), HttpStatus.OK);
	}
}
