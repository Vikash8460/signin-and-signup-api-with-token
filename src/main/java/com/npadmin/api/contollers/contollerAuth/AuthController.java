package com.npadmin.api.contollers.contollerAuth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.npadmin.api.dtos.AuthenticationRequest;
import com.npadmin.api.dtos.AuthenticationResponse;
import com.npadmin.api.dtos.UserRequest;
import com.npadmin.api.dtos.UserResponse;
import com.npadmin.api.dtos.UserResponse2;
import com.npadmin.api.models.modelUser.User;
import com.npadmin.api.repositors.repositorUser.UserRepository;
import com.npadmin.api.services.serviceUser.UserDetailsServiceImpl;
import com.npadmin.api.services.serviceUser.UserService;
import com.npadmin.api.utils.JwtUtil;
import com.npadmin.api.wconfigs.AES;

@RestController
@RequestMapping("/api")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping("/dummy")
	String hello() {
		return "hello man";
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/signup")
	public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest) {
		User registeredUser = userService.registerUser(userRequest);

		try {
			AES aes = new AES();
			aes.init();
			// Serialize the User object to JSON
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonUserData = objectMapper.writeValueAsString(registeredUser);

			// Encrypt the JSON data before saving
			String encryptedData = aes.encrypt(jsonUserData);

			String decryptedData1 = aes.decrypt(encryptedData);
			User decryptedData = objectMapper.readValue(decryptedData1, User.class);

			UserResponse successResponse = new UserResponse(new Date(), HttpStatus.CREATED.value(),
					"User registered successfully", encryptedData);
			return ResponseEntity.ok(successResponse);

//	           UserResponse2 successResponse = new UserRsponse2(new Date(), HttpStatus.CREATED.value(),
//						"User registered successfully", decryptedData);
//		        return ResponseEntity.ok(successResponse);   
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(null);
		}
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));

			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String jwt = jwtUtil.generateToken(userDetails);

			try {
				AES aes = new AES();
				aes.init();
				// Serialize the User object to JSON
				ObjectMapper objectMapper = new ObjectMapper();
				String jsonUserData = objectMapper.writeValueAsString(jwt);
				String encryptedData = aes.encrypt(jsonUserData);
				return ResponseEntity.ok(new AuthenticationResponse(encryptedData));
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(500).body(null);
			}
			// return ResponseEntity.ok(new AuthenticationResponse(jwt));
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
		}
	}
	
	@GetMapping("/decrypt/{encryptedData}")
	public ResponseEntity<UserResponse2> getdecrypteddata(@PathVariable String encryptedData) {

		ObjectMapper objectMapper = new ObjectMapper();
		User decryptedData = null;

		try {
			AES aes = new AES();
			aes.init();
			String decryptedData1 = aes.decrypt(encryptedData);
			decryptedData = objectMapper.readValue(decryptedData1, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UserResponse2 successResponse = new UserResponse2(new Date(), HttpStatus.CREATED.value(),
				"User registered successfully", decryptedData);
		return ResponseEntity.ok(successResponse);
	}


}
