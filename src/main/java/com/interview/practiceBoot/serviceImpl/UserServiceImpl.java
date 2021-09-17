package com.interview.practiceBoot.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.practiceBoot.io.Entity.UserEntity;
import com.interview.practiceBoot.repositories.UserRepository;
import com.interview.practiceBoot.service.UserService;
import com.interview.practiceBoot.service.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDto saveUser(UserDto dto) {
		UserDto returnvalue = new UserDto();
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(dto, userEntity);

		UserEntity userDetails = userRepo.save(userEntity);

		BeanUtils.copyProperties(userDetails, returnvalue);

		return returnvalue;
	}

}
