package com.microservice_3.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice_3.dto.User;


@FeignClient(name = "AUTHSERVICE")
public interface AuthServiceFeignClient {

	
	 @GetMapping("/api/vi/auth/get-user")
	    User getUserByUsername(@RequestParam("username") String username, @RequestHeader("Authorization") String token);
	
}