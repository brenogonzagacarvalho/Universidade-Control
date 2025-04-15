package com.autoestudo.backEnd.repository;

import com.autoestudo.backEnd.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}