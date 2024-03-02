package com.npadmin.api.services.serviceUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.npadmin.api.dtos.UserRequest;
import com.npadmin.api.models.modelUser.User;
import com.npadmin.api.repositors.repositorUser.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	
	@Autowired
	UserRepository userRepository;
	
    @Autowired
    private  PasswordEncoder passwordEncoder;

    public User registerUser(UserRequest request) {
    	   
        User user1 = new User();
        user1.setUserId(request.getUserId());    
        user1.setPassword(passwordEncoder.encode(request.getPassword()));
//        user1.setToken(jwtUtil.generateToken(request.getUserId()));
        user1.setMobile(request.getMobile());
        user1.setEmail(request.getEmail());
        userRepository.save(user1);
        return user1;

        }

}
