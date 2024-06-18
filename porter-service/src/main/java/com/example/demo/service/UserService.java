package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.User;

public interface UserService {
    ApiResponse signUp(User user);
    ApiResponse confirmEmail(String token);
	
	public List<UserEntity> getAllUsers();
     public String updateUser(User user);
	ApiResponse login(User user);
}
