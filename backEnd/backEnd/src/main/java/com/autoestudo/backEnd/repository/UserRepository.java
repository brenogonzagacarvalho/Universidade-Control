package com.autoestudo.backEnd.repository;

import com.autoestudo.backEnd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}