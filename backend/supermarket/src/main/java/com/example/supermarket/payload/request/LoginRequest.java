package com.example.supermarket.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "Please provide your email!")
    @Email(message = "Please provide a valid email")
    private String email;

    @NotBlank(message = "Please provide your password!")
    private String password;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
