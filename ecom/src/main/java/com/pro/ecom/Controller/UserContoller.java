package com.pro.ecom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.ecom.Model.User;
import com.pro.ecom.Repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserContoller {
	
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("/add")
	public ResponseEntity<?> addRegister(@RequestBody User user){
		user.setRole("user");
		
		User savedEntity =userRepo.saveAndFlush(user);
		return ResponseEntity.status(HttpStatus.OK)
				.body(user);	
	}
	@GetMapping("/check")
	public ResponseEntity<?> RegisterId(@RequestParam String username,@RequestParam String password){
		User user= userRepo.findBy(username, password);
		return ResponseEntity.status(HttpStatus.OK)
				.body(user);	
	}

}
