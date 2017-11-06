package fr.esipe.dataaccess.user.services;

import fr.esipe.clientmodels.models.AccountDto;
import fr.esipe.clientmodels.models.UserDto;

import java.util.List;
import java.util.Optional;

/**
 * @author Warren D'ALMEIDA
 */

public interface IAccountService {
	AccountDto create(AccountDto accountDto);
}
