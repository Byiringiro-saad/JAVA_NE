package com.example.supermarket.services.userDetails;

import com.example.supermarket.models.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Optional;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Long id;

    private String firstname;

    private String phone;

    private String email;

    private String role;

    private String password;


    public UserDetailsImpl(Long id, String firstname, String phone, String email, String password, String role) {
        this.id = id;
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    public static UserDetailsImpl build(Optional<UserModel> user) {

        return new UserDetailsImpl(
                user.get().getId(),
                user.get().getFirstname(),
                user.get().getPhone(),
                user.get().getEmail(),
                user.get().getPassword(),
                user.get().getRole());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
