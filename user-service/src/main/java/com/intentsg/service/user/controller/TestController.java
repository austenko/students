package com.intentsg.service.user.controller;
import com.intentsg.service.user.config.SpringFoxConfig;
import com.intentsg.model.Ticket;
import com.intentsg.model.User;
import com.intentsg.service.user.dto.UserDTO;
import com.intentsg.service.user.repository.UserRepository;
import com.intentsg.service.user.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/api")
public class TestController {

	@Autowired
	private UserService userService;

	@GetMapping("/test")
	public ResponseEntity test() {
		return ResponseEntity.ok("user-service");

	}

	@GetMapping("/list")
	public ResponseEntity<List<UserDTO>> list()	{
		return ResponseEntity.ok(userService.getAllUserList());

	}

	@RequestMapping(value="/list/{lastName}",method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getList(@PathVariable("lastName") String lastName)	{
		return ResponseEntity.ok(userService.getUsersByLastName(lastName));
	}

	@RequestMapping(value="/user/{id}",method = RequestMethod.GET)
	public ResponseEntity <Object> getUserById(@PathVariable("id") long id)	{
		UserDTO userDTO =userService.getUserById(id);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

	@RequestMapping(value="/user",method = RequestMethod.POST)
	public ResponseEntity createUser(@RequestBody User user)	{
		userService.createUsr(user);
		return new ResponseEntity<>("User is created successfully with id= " + user.getUserId(), HttpStatus.CREATED);
	}

	@RequestMapping(value="/user/{id}",method = RequestMethod.DELETE)
	public ResponseEntity <Object> deleteUserById(@PathVariable("id") long id)	{
		userService.deleteUsrById(id);
		return new ResponseEntity<>("User with id= " + id + " successfully deleted", HttpStatus.OK);
	}
}
