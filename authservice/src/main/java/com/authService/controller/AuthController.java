package com.authService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authService.dto.APIResponse;
import com.authService.dto.LoginDto;
import com.authService.dto.UserDto;
import com.authService.entity.User;
import com.authService.repository.UserRepository;
import com.authService.service.AuthService;
import com.authService.service.JwtService;

@RestController
@RequestMapping("/api/vi/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/register")
	public ResponseEntity<APIResponse<String>> register(@RequestBody UserDto dto){
		APIResponse<String> response = authService.register(dto);
		return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus())) ;
	}
	
	@PostMapping("/login")
	public ResponseEntity<APIResponse<String>> login(@RequestBody LoginDto dto){
		
		APIResponse<String> response = new APIResponse<>();
		
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(dto.getUsername() , dto.getPassword());
		
		try {
			 Authentication authenticate = authManager.authenticate(token);
			 
			 if(authenticate.isAuthenticated()) {
				 String jwtToken = jwtService.generateToken(dto.getUsername(),
			                authenticate.getAuthorities().iterator().next().getAuthority());

			            response.setMessage("Login Successful");
			            response.setStatus(200);
			            response.setData(jwtToken);  // return JWT
			            return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
			        }
		} catch (Exception e) {
			e.printStackTrace();
	}
		
		 response.setMessage("Failed");
		 response.setStatus(401);
		 response.setData("Un-Authorized Access");
		 return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
	}
	
	@GetMapping("/get-user")
	public User getUserByUserName(@RequestParam String username) {
		User user = repository.findByUsername(username);
		return user;
	}
}
