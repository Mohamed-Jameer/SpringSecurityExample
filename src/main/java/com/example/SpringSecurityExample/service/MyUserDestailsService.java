package com.example.SpringSecurityExample.service;

import com.example.SpringSecurityExample.model.UserPrincipal;
import com.example.SpringSecurityExample.model.Users;
import com.example.SpringSecurityExample.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDestailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUserName(username);
        System.out.println(user);

        if(user == null){
            System.out.println("User Not Found");
            throw  new UsernameNotFoundException("User Not Found");
        }
        return new UserPrincipal(user);
    }
}
