package com.example.SpringSecurityExample.service;

import com.example.SpringSecurityExample.model.Users;
import com.example.SpringSecurityExample.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users users){
        users.setPassword(encoder.encode(users.getPassword()));
       return  repo.save(users);
    }

    public String verify(Users users) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUserName(),users.getPassword()));
        if(authentication.isAuthenticated()){
           return  jwtService.generateToken(users.getUserName());
        }

           return  "Failed";
    }
}
