package com.karthitox.oneforum.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.karthitox.oneforum.exception.UserAlreadyExistException;
import com.karthitox.oneforum.exception.UserNotFoundException;
import com.karthitox.oneforum.model.Role;
import com.karthitox.oneforum.model.User;
import com.karthitox.oneforum.model.dto.AuthenticationRequestDTO;
import com.karthitox.oneforum.model.dto.AuthenticationResponseDTO;
import com.karthitox.oneforum.repository.UserRepository;
import com.karthitox.oneforum.security.JwtService;

import lombok.AllArgsConstructor;

@Service
public class AuthService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtService jwtService;

	public User fetchUserByEmail(String email)
			throws UserNotFoundException {
		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());
	}
	
	public AuthenticationResponseDTO loginUser(AuthenticationRequestDTO authData)
			throws UserNotFoundException {
		Optional<User> user = userRepository.findByEmail(authData.getEmail());

		if (user.isEmpty()) {
			throw new UserNotFoundException();
		}

		// verifying the password
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.get().getEmail(), authData.getPassword()));

		String jwtToken = jwtService.generateToken(user.get());
		log.debug("user token: " + jwtToken);

		AuthenticationResponseDTO response = new AuthenticationResponseDTO();
		response.setToken(jwtToken);
		response.setUser(user.get());

		return response;
	}

	public AuthenticationResponseDTO registerUser(AuthenticationRequestDTO authData, Role role)
			throws UserAlreadyExistException {
		
		if (userRepository.findByEmail(authData.getEmail()).isPresent()) {
			throw new UserAlreadyExistException();
		}

		log.debug("user not exist, registering new user");

		User user = new User();
		user.setEmail(authData.getEmail());
		user.setPassword(passwordEncoder.encode(authData.getPassword()));
		user.setName(removeNonAlphanumeric(authData.getEmail().split("@")[0]));
		user.setRole(role);

		userRepository.save(user);
		
		log.debug("created new user: " + user);

		// verifying the password
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), authData.getPassword()));

		String jwtToken = jwtService.generateToken(user);
		log.debug("user token: " + jwtToken);

		AuthenticationResponseDTO response = new AuthenticationResponseDTO();
		response.setToken(jwtToken);
		response.setUser(user);

		return response;
	}

	private String removeNonAlphanumeric(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", "");
		return str;
	}

}
