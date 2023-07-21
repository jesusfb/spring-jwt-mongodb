package com.auth.jwtserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.jwtserver.document.User;
import com.auth.jwtserver.service.UserService;
import com.auth.jwtserver.utility.ResponseBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
	@Autowired
    UserService userService;

	@Operation(summary = "Get User Profile")
    @GetMapping("/profile")
	@SecurityRequirement(name = "bearerAuthToken")
    public ResponseEntity<Object> getUserProfile(@AuthenticationPrincipal User user) {
    	return ResponseBuilder.build(HttpStatus.OK, null, "Success", user);
    }

	@Operation(summary = "Get Other Users Profile")
    @GetMapping("/{id}")
    @PreAuthorize("#user.id == #id")
	@SecurityRequirement(name = "bearerAuthToken")
    public ResponseEntity<Object> getUserById(@AuthenticationPrincipal User user, @PathVariable String id) {
    	User userProfile = userService.findById(id);
    	return ResponseBuilder.build(HttpStatus.OK, null, "Success", userProfile);
    }
    
	@Operation(summary = "Delete Users Profile")
    @DeleteMapping("/{id}")
    @PreAuthorize("#user.id == #id")
	@SecurityRequirement(name = "bearerAuthToken")
    public ResponseEntity<Object> deleteUserById(@AuthenticationPrincipal User user, @PathVariable String id) {
    	userService.deleteUserById(id);
    	return ResponseBuilder.build(HttpStatus.OK, null, "Account Deleted", null);
    }
}
