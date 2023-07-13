package com.karthitox.oneforum.service;

import java.util.Optional;
import java.util.UUID;

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
public class UserService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;

	public User fetchUserByEmail(String email)
			throws UserNotFoundException {
		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());
	}
	
	public User fetchUserById(UUID uid)
			throws UserNotFoundException {
		return userRepository.findById(uid).orElseThrow(() -> new UserNotFoundException());
	}

}
