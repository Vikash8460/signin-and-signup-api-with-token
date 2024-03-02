package com.npadmin.api.services.serviceUser;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.npadmin.api.models.modelUser.User;
import com.npadmin.api.repositors.repositorUser.UserRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepository;

	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByUserId(username)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

	        return new org.springframework.security.core.userdetails.User(
	                user.getUserId(), user.getPassword(), new CopyOnWriteArrayList<>());
	    }
	}