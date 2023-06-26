package com.example.supermarket.payload.response;


public class JwtResponse {
    private String token;

    private String type = "Bearer";

    private Long id;

    private String firstname;

    private String phone;

    private String email;

    private String role;

    public JwtResponse(String token, Long id, String firstname, String phone, String email, String role) {
        this.token = token;
        this.id = id;
        this.firstname = firstname;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

}
