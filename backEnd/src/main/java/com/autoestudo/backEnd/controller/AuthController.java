package com.autoestudo.backEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoestudo.backEnd.entity.User;
import com.autoestudo.backEnd.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private UserService userService;

  private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody User loginRequest) {
    User user = userService.findByEmail(loginRequest.getEmail());
    if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
      return ResponseEntity.ok(user); // Retorna o usuário autenticado
    }
    return ResponseEntity.status(401).body("Credenciais inválidas");
  }
}