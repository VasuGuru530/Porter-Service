package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.Signin;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signUp(@RequestBody User user  ) {
        ApiResponse response = userService.signUp(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
	public List<UserEntity> getAllUsers(){
		return userService.getAllUsers();
	}
    
	//Update
	@PutMapping("/update")
	public String updateEmployee(@RequestBody User user) {
		return userService.updateUser(user);
	}

    @GetMapping("/confirm")
    public ResponseEntity<ApiResponse> confirmEmail(@RequestParam String token) {
        ApiResponse response = userService.confirmEmail(token);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody Signin signin) {
        ApiResponse response = userService.login(signin);
        return ResponseEntity.ok(response);
    }
}

