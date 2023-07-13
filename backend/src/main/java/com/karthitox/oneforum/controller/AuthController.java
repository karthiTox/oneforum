package com.karthitox.oneforum.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.karthitox.oneforum.exception.UserAlreadyExistException;
import com.karthitox.oneforum.exception.UserNotFoundException;
import com.karthitox.oneforum.model.*;
import com.karthitox.oneforum.model.dto.AuthenticationRequestDTO;
import com.karthitox.oneforum.model.dto.AuthenticationResponseDTO;
import com.karthitox.oneforum.service.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody AuthenticationRequestDTO request)
			throws UserAlreadyExistException {
		return ResponseEntity.ok(authService.registerUser(request, Role.USER));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody AuthenticationRequestDTO request)
			throws UserNotFoundException {
		return ResponseEntity.ok(authService.loginUser(request));
	}

	@GetMapping("/user")
	@ResponseBody
	public User currentUser(Authentication authentication) throws UserNotFoundException {
		String email = authentication.getName();

		return authService.fetchUserByEmail(email);
	}
	
	@RequestMapping("/api/user/{uid}")
	@ResponseBody
	public UUID getuser(@RequestParam UUID uid) throws UserNotFoundException {
		return uid;
	}

}
