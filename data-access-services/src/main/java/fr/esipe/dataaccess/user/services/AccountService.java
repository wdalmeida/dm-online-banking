package fr.esipe.dataaccess.user.services;

import fr.esipe.clientmodels.models.AccountDto;
import fr.esipe.clientmodels.models.UserDto;
import fr.esipe.dataaccess.user.entities.AccountEntity;
import fr.esipe.dataaccess.user.entities.UserEntity;
import fr.esipe.dataaccess.user.repositories.AccountRepository;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Warren D'ALMEIDA
 */
@Service
public class AccountService implements IAccountService {

	private final Logger logger = LoggerFactory.getLogger(AccountService.class);

	private final AccountRepository accountRepository;

	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	

	@Override
	public AccountDto create(AccountDto accountDto) {
		logger.debug("Create Account");
		AccountEntity ae = new AccountEntity();
		ae.setAmount(accountDto.getAmount());
		ae.setType(accountDto.getType());
		UserDto userDto= accountDto.getUser();
		UserEntity ue = new UserEntity();
		ue.setId(Long.parseLong(userDto.getId()));
		ae.setUser(ue);
		AccountEntity ae1 = accountRepository.save(ae);
		return AccountDto.builder()
				.numco(ae1.getNumco())
				.amount(ae1.getAmount())
				.type(ae1.getType())
				.user(UserDto.builder().id(String.valueOf(ue.getId())).build())
				.build();
	}
}
