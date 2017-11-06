package fr.esipe.dataaccess.user.repositories;

import fr.esipe.dataaccess.user.entities.AccountEntity;
import fr.esipe.dataaccess.user.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Warren D'ALMEIDA
 */
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
}
