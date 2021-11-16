package com.intentsg.service.user.controller;

import com.intentsg.service.user.service.ServiceClass;
import com.intentsg.service.user.userdto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/users")
public class TestController {

	@Autowired
	ServiceClass serviceClass;

	@GetMapping("/test")
	public ResponseEntity test() {
		return ResponseEntity.ok("user-service");
	}

	@GetMapping("/list")
	public ResponseEntity <List<UserDto>>list() {
		return ResponseEntity.ok(serviceClass.findAllUsers());
	}


@RequestMapping(value="/find/{firstName}",method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>>getByFirstName(@PathVariable("firstName") String firstName) {
		return ResponseEntity.ok(serviceClass.findAllByFirstName(firstName)) ;
	}







}

