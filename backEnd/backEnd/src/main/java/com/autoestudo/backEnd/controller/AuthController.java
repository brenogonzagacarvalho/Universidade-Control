package com.autoestudo.backEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoestudo.backEnd.entity.User;
import com.autoestudo.backEnd.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody User loginRequest) {
    User user = userRepository.findByEmail(loginRequest.getEmail());
    if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
      return ResponseEntity.ok(user); // Retorna o usuário autenticado
    }
    return ResponseEntity.status(401).body("Credenciais inválidas");
  }
}