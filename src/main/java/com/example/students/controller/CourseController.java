package com.example.students.controller;

import com.example.students.model.Course;
import com.example.students.model.Student;
import com.example.students.model.dto.request.StudentRequest;
import com.example.students.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public Course add(String name){
        return courseService.addCourse(name);
    }

    @PostMapping("/delete")
    public String delete(Long id){
        return courseService.delete(id);
    }
}
