package com.authService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/welcome")
public class welcomeController {

	//http://localhost:8081/api/vi/welcome/message
	@GetMapping("/message")
	public String welcome() {
		return "Welcome To Shivapura";
	}
	
}
