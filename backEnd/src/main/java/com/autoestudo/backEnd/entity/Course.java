package com.autoestudo.backEnd.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String acronym;

    @Column(nullable = false)
    private String shift; // manhã, tarde ou noite
}