package com.angularSpringBoot.demo.controller;
import com.angularSpringBoot.demo.model.Course;
import com.angularSpringBoot.demo.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor // Gera o construtor através do lombock
public class CoursesController {
    @Autowired
    public final CourseRepository courseRepository;

//    public CoursesController(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//   }

    @GetMapping
    public List<Course> list(){
        return courseRepository.findAll();
    }
}
