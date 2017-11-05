package fr.esipe.dataaccess.user.controllers;

import fr.esipe.dataaccess.user.models.UserDto;
// import org.springframework.data.domain.PageRequest;
import fr.esipe.dataaccess.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Warren D'ALMEIDA
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") String id) {
		// TODO
		final Optional<UserDto> dtoOpt = userService.getUserById(id);
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

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
		return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody UserDto user) {
		// TODO
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String id) {
		// TODO
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
