package com.authService.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authService.dto.APIResponse;
import com.authService.dto.UserDto;
import com.authService.entity.User;
import com.authService.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public APIResponse<String> register( UserDto userDto){
		//API Response object
		
		APIResponse<String> response = new APIResponse<>();
		
		//check whether username exists
		
		if(userRepository.existsByUsername(userDto.getUsername())) {
			response.setMessage("Registration failed");
			response.setStatus(500);
			response.setData("User with user name already exists");
			return response;
		}
		
		//check whether Email exists
		
		if(userRepository.existsByEmail(userDto.getEmail())) {
			response.setMessage("Registration failed");
			response.setStatus(500);
			response.setData("User with user name already exists");
			return response;
		}
		
		//Encode the password before saving that to the database
		String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
		
		User user = new User();
		
		BeanUtils.copyProperties(userDto, user);
		user.setPassword(encryptedPassword);
		user.setRole("ROLE_ADMIN");
		
		User savedUser = userRepository.save(user);
		
		if(savedUser==null) {
			//custom exception
		}
		
		response.setMessage("Registration Completeed");
		response.setStatus(201);
		response.setData("User has been registerd");
		return response;
		//finally save the user and return response as APIResponse
				
				
	}
}
