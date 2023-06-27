package com.example.supermarket.services.userDetails;

import com.example.supermarket.models.UserModel;
import com.example.supermarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public UserDetails loadByEmail(String email) {
        Optional<UserModel> user =  userRepository.findByEmail(email);

        return UserDetailsImpl.build(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserModel> user =  userRepository.findByEmail(email);

        return UserDetailsImpl.build(user);
    }
}
