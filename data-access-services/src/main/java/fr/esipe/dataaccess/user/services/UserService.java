package fr.esipe.dataaccess.user.services;

import fr.esipe.clientmodels.models.AccountDto;
import fr.esipe.dataaccess.user.entities.AccountEntity;
import fr.esipe.dataaccess.user.entities.UserEntity;
import fr.esipe.clientmodels.models.UserDto;
import fr.esipe.dataaccess.user.repositories.UserRepository;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Warren D'ALMEIDA
 */
@Service
public class UserService implements IUserService {

	private final Logger logger = LoggerFactory.getLogger(UserService.class);

	private final UserRepository userRepository;

	private DozerBeanMapper mapper = new DozerBeanMapper();

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDto> getAll() {
		return userRepository.findAll()
			.stream()
			.map(
				u -> UserDto.builder()
				.id(String.valueOf(u.getId()))
				.firstName(u.getFirstName())
				.lastName(u.getLastName())
				.build()
			)
			.collect(Collectors.toList());
	}

	@Override
	public Optional<UserDto> getUserById(String id) {
		UserEntity userEntity = userRepository.findOne(Long.parseLong(id));
		return (userEntity != null) ?
			Optional.of(
				UserDto.builder()
					.id(String.valueOf(userEntity.getId()))
					.firstName(userEntity.getFirstName())
					.lastName(userEntity.getLastName())
						.street(userEntity.getStreet())
						.city(userEntity.getCity())
						.postalCode(userEntity.getPostalCode())
						.phone(userEntity.getPhone())
						.build()
			)
			: Optional.empty();
	}

	@Override
	public UserDto create(UserDto userDto) {
		logger.debug("Create User");
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());
		userEntity.setStreet(userDto.getStreet());
		userEntity.setCity(userDto.getCity());
		userEntity.setPostalCode(userDto.getPostalCode());
		userEntity.setPhone(userDto.getPhone());
		UserEntity userEntity1 = userRepository.save(userEntity);

		return UserDto.builder()
			.id(String.valueOf(userEntity1.getId()))
			.firstName(userEntity1.getFirstName())
			.lastName(userEntity1.getLastName())
			.street(userEntity1.getStreet())
			.city(userEntity1.getCity())
			.postalCode(userEntity1.getPostalCode())
			.phone(userEntity1.getPhone())
			.build();
	}

	@Override
	public void delete(String id) {

	}

	@Override
	public void update(String id, UserDto userDto) {
		logger.debug("Update User");
		UserEntity userEntity = new UserEntity();
		userEntity.setId(Long.parseLong(id));
		userEntity.setStreet(userDto.getStreet());
		userEntity.setCity(userDto.getCity());
		userEntity.setPostalCode(userDto.getPostalCode());
		userEntity.setPhone(userDto.getPhone());
		userRepository.save(userEntity);
	}
}
