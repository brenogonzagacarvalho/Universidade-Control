package com.autoestudo.backEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.autoestudo.backEnd.entity.Course;
import com.autoestudo.backEnd.entity.User;
import com.autoestudo.backEnd.repository.CourseRepository;
import com.autoestudo.backEnd.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User save(User user) {
        System.out.println("Dados recebidos no backend: " + user);
        if (user.getCourse() != null) {
            Course course = courseRepository.findById(user.getCourse().getId())
                    .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
            user.setCourse(course);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash da senha
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User update(Long id, User user) {
        System.out.println("Dados recebidos no backend: " + user);
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword())); // Atualiza o hash da senha
        existingUser.setActive(user.isActive());
        if (user.getCourse() != null) {
            Course course = courseRepository.findById(user.getCourse().getId())
                    .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
            existingUser.setCourse(course);
        }
        return userRepository.save(existingUser);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (!user.isActive()) {
            userRepository.delete(user);
        } else {
            throw new RuntimeException("Não é possível excluir um usuário ativo");
        }
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}