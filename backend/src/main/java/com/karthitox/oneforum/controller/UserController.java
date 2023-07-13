package com.karthitox.oneforum.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{uid}")
	@ResponseBody
	public User getuser(@PathVariable("uid") UUID uid) throws UserNotFoundException {
		return userService.fetchUserById(uid);
	}

}
