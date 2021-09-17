package com.interview.practiceBoot.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.practiceBoot.service.UserService;
import com.interview.practiceBoot.service.dto.UserDto;
import com.interview.practiceBoot.ui.requestmodel.UserRequestModel;
import com.interview.practiceBoot.ui.responsemodel.UserResponseModel;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public String getUser() {
		return "getUser called";
	}

	@PostMapping
	public UserResponseModel createUser(@RequestBody UserRequestModel userRequestModel) {
		UserResponseModel returnValue= new UserResponseModel();
		UserDto userDto= new UserDto();
		
		BeanUtils.copyProperties(userRequestModel, userDto );
		
	UserDto saveuser=	userService.saveUser(userDto);
		BeanUtils.copyProperties(saveuser, returnValue);
		
		
		return returnValue;
	}

	@PutMapping
	public String updateuser() {
		return "update user was called";
	}

	@DeleteMapping
	public String deleteuser() {

		return "delete user was called";
	}
}
