package com.pro.ecom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.ecom.Model.Product;
import com.pro.ecom.Model.User;
import com.pro.ecom.Repo.UserRepo;
import com.pro.ecom.response.ApiResponse;

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
	@GetMapping("/listuser")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return ResponseEntity.ok(userList);
    }
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<ApiResponse> deleteUser(@PathVariable int id) {
	        try {
	            if (userRepo.existsById(id)) {
	                userRepo.deleteById(id);
	                return ResponseEntity.ok(new ApiResponse("User deleted successfully"));
	            } else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User not found"));
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failed to Usernp product"));
	        }
	    }

	@GetMapping("/check")
	public ResponseEntity<?> RegisterId(@RequestParam String username,@RequestParam String password){
		User user= userRepo.findBy(username, password);
		return ResponseEntity.status(HttpStatus.OK)
				.body(user);	
	}

}
