package com.intentsg.service.user.controller;

import com.intentsg.model.User;
import com.intentsg.service.user.service.ServiceClass;
import com.intentsg.service.user.userdto.UserDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Pageable;
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
//	@GetMapping("/getById")
//	public ResponseEntity <List<UserDto>>getById() {
//		return ResponseEntity.ok(serviceClass.getUsersByByUserId(1l));
//	}
@GetMapping("/find")
public ResponseEntity <List<UserDto>>find() {
	return ResponseEntity.ok(serviceClass.findAllByFirstName("Lisa"));
}


//	@GetMapping("/list")
//	public ResponseEntity<List<UserDTO>> list()	{
//		Pageable sortedUserByAlias = PageRequest.of(0, 10);
//		return ResponseEntity.ok(serviceClass.getAllUserList(sortedUserByAlias));
//	}


//	@GetMapping("/allUsers")
//		@ApiOperation(value = " List of Users ", response = UserDto.class, tags = "findAll");
//		public List<UserDto> findAll() {
//			return serviceClass.findAllUsers();
//		}



}
//	@GetMapping("/test")
//	public ResponseEntity test() {
//		return ResponseEntity.ok("user-service");
//	}
//}
