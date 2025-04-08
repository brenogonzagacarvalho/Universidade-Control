package com.autoestudo.backEnd.service;

import com.autoestudo.backEnd.entity.Course;
import com.autoestudo.backEnd.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}