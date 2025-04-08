package com.autoestudo.backEnd.controller;

import com.autoestudo.backEnd.entity.Course;
import com.autoestudo.backEnd.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseService.save(course);
    }

    @GetMapping
    public List<Course> list() {
        return courseService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
}