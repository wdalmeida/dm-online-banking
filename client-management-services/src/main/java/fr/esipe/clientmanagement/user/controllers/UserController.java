package fr.esipe.clientmanagement.user.controllers;

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
@RequestMapping(path = "/users")
public class UserController {

	private AccessAdvisor aa= new AccessAdvisor();


	/**
	 * Get user data with the given id
	 *
	 * @param id Long
	 * @return data in JSON
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> get(@PathVariable Long id) {
		final Optional<UserDto> dtoOpt = Optional.of((aa.getEntity("/users/"+id, UserDto.class)));
		return (dtoOpt.isPresent()) ?
			new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * If page and size request parameters are filled, return a page. Otherwise, return a list of all elements.
	 *
	 * @param page      Page index, starts with 0
	 * @param size      Page size
	 * @return          Can return a TODO @link org.springframework.data.domain.Page OR a {@link List} of DTO
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> get(
		@RequestParam(value = "page", required = false) Integer page,
		@RequestParam(value = "size", required = false) Integer size
	) {
		// Pagination
		if (page != null && size != null) {
			// TODO
		}

		// TODO
		final List<UserDto> userDtoList = Collections.emptyList();
		return (!userDtoList.isEmpty()) ?
			new ResponseEntity<>(userDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Add a user into the database
	 *
	 * @param user using JSON
	 * @return user in JSON
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
		UserDto newUser = aa.addEntity("/users", user, UserDto.class);
		return new ResponseEntity<UserDto>(newUser,HttpStatus.OK);
	}

	/**
	 * Modify the user phone number and address
	 *
	 * @param id String
	 * @param user using JSON
	 * @return OK
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody UserDto user) {
		aa.putEntity("/users/"+id, user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
