package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private EmailService emailService;
    
    @Override
    public ApiResponse signUp(User user) {
        Optional<UserEntity> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return new ApiResponse(false, "Email address already in use.");
        }
        
        user.setCreatedDate(LocalDateTime.now());
        user.setCreatedBy("system");
        user.setStatus("PENDING");
        UserEntity userEntity = modelMapper.map(user, UserEntity.class); 
      
     // Generate confirmation token
        String token = UUID.randomUUID().toString();
        userEntity.setConfirmationToken(token);

        userRepository.save(userEntity);

        // Send confirmation email
        String confirmationLink = "http://localhost:8080/api/users/confirm?token=" + token;
        String emailBody = "Thank you for registering. Please click the link to confirm your email: " + confirmationLink;
        emailService.sendEmail(user.getEmail(), "Email Confirmation", emailBody);

        return new ApiResponse(true, "User registered successfully. Please check your email for confirmation.");  
        }

    @Override
    public ApiResponse confirmEmail(String token) {
        Optional<UserEntity> userEntityOptional = userRepository.findByConfirmationToken(token);
        if (!userEntityOptional.isPresent()) {
            return new ApiResponse(false, "Invalid or expired token.");
        }

        UserEntity userEntity = userEntityOptional.get();
        userEntity.setStatus("ACTIVE");
        userEntity.setConfirmationToken(null); // Clear the token
        userEntity.setUpdatedDate(LocalDateTime.now());
        userEntity.setUpdatedBy("system");

        userRepository.save(userEntity);

        return new ApiResponse(true, "Email confirmed successfully.");
    }
    
    
	@Override
	public List<UserEntity> getAllUsers() {
		String test="user Details Updated successfully";
		return userRepository.findAll();
	}

	@Override
	public String updateUser(User user) {
		String test="User Details Updated successfully";
	
        user.setUpdatedDate(LocalDateTime.now());
        user.setUpdatedBy("system");
        
		UserEntity userEntity = modelMapper.map(user, UserEntity.class); 
		userRepository.save(userEntity);
		
		return "User Details Updated successfully";
	
	}
	 @Override
	    public ApiResponse login(User user) {
	        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(user.getEmail());
	        if (!userEntityOptional.isPresent() || !userEntityOptional.get().getPassword().equals(user.getPassword())) {
	            return new ApiResponse(false, "Invalid email or password.");
	        }

	        UserEntity userEntity = userEntityOptional.get();
	        if (!"ACTIVE".equals(userEntity.getStatus())) {
	            return new ApiResponse(false, "Email not confirmed. Please confirm your email.");
	        }

	        return new ApiResponse(true, "Login successful.");
	    }
}
