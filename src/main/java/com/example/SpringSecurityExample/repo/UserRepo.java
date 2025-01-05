package com.example.SpringSecurityExample.repo;

import com.example.SpringSecurityExample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByUserName(String userName); // Use the correct field name
}
