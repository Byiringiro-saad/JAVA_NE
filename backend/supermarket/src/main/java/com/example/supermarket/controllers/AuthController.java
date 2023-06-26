package com.example.supermarket.controllers;

import com.example.supermarket.models.UserModel;
import com.example.supermarket.payload.request.LoginRequest;
import com.example.supermarket.payload.request.SignupRequest;
import com.example.supermarket.payload.response.JwtResponse;
import com.example.supermarket.payload.response.MessageResponse;
import com.example.supermarket.repository.UserRepository;
import com.example.supermarket.security.jwt.JwtUtils;
import com.example.supermarket.services.userDetails.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = JwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getFirstname(), userDetails.getPhone(), userDetails.getEmail(), userDetails.getRole()));
    }

    @PostMapping("/signup")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> registerUser (@Valid @RequestBody SignupRequest signupRequest){
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in used"));
        }

        //create user account
        UserModel userModel = new UserModel(signupRequest.getFirstname(), signupRequest.getPhone(), signupRequest.getEmail(), passwordEncoder.encode(signupRequest.getPassword()), signupRequest.getRole());
        userRepository.save(userModel);

        return ResponseEntity.ok(new MessageResponse("User registered"));

    }

}
