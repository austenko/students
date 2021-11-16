package com.intentsg.service.user.controller;
import com.intentsg.service.user.config.SpringFoxConfig;
import com.intentsg.model.Ticket;
import com.intentsg.model.User;
import com.intentsg.service.user.dto.UserDTO;
import com.intentsg.service.user.repository.UserRepository;
import com.intentsg.service.user.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/users")
public class TestController {

	@Autowired
	private UserService userService;

	@GetMapping("/test")
	public ResponseEntity test() {
		return ResponseEntity.ok("user-service");

	}

	@GetMapping("/list")
	public ResponseEntity<List<UserDTO>> list()	{
		Pageable sortedUserByAlias = PageRequest.of(0, 10, Sort.by("alias"));
		return ResponseEntity.ok(userService.getAllUserList(sortedUserByAlias));
	}

	@RequestMapping(value="/list/{lastName}",method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getList(@PathVariable("lastName") String lastName)	{
		return ResponseEntity.ok(userService.getUsersByLastName(lastName));
	}

	@RequestMapping(value="/user/{id}",method = RequestMethod.GET)
	public ResponseEntity <Object> getUserByIdOrThrowsNotFoundException(@PathVariable("id") long id) throws NotFoundException {
		UserDTO userDTO =userService.getUserById(id);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

	@RequestMapping(value="/user",method = RequestMethod.POST)
	public ResponseEntity createUser(@RequestBody User user)	{
		userService.createUsr(user);
		return new ResponseEntity<>("User was created successfully with id= " + user.getUserId(), HttpStatus.CREATED);
	}

	@RequestMapping(value="/user/{id}",method = RequestMethod.DELETE)
	public ResponseEntity <Object> deleteUserById(@PathVariable("id") long id) throws NotFoundException {
		UserDTO userDTO = userService.deleteUsrById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "User with id = " + id + " successfully deleted");
		return new ResponseEntity<>(userDTO, headers , HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity updateUserAnyFieldByIdOrThrowsNotFoundException(@RequestBody User user) throws NotFoundException {
		userService.updateUserAnyFieldByIdByRepositoryInBoxMethod(user);
		return new ResponseEntity<>("User with id = " + user.getUserId() + " successfully updated", HttpStatus.OK);
	}


}
