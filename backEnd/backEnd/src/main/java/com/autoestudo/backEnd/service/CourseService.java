package com.autoestudo.backEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoestudo.backEnd.entity.Course;
import com.autoestudo.backEnd.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public Course update(Long id, Course course) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + id));
        existingCourse.setName(course.getName());
        existingCourse.setAcronym(course.getAcronym());
        existingCourse.setShift(course.getShift());
        return courseRepository.save(existingCourse);
    }
}