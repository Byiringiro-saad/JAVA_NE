package com.example.supermarket.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class SignupRequest {
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @NotBlank(message = "Please provide your names")
    public String firstname;

    @NotBlank(message = "Please provide your email")
    @Email(message = "Please provide a valid email")
    public String email;

    @NotBlank(message = "Please provide your phone number")
    public  String phone;

    @NotBlank(message = "Please provide your password")
    public String password;

    @NotBlank
    public String role;
}
