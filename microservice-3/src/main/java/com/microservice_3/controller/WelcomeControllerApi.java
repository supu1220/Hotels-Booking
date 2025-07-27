package com.microservice_3.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControllerApi {
	
	@GetMapping("/message")
	public String getMessage() {
		return "R YOU COMING TO SHIVAPURA";
	}

}