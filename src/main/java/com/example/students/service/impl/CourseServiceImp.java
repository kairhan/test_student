package com.example.students.service.impl;

import com.example.students.model.Course;
import com.example.students.model.Student;
import com.example.students.model.dto.request.StudentRequest;
import com.example.students.repository.CourseRepository;
import com.example.students.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public Course addCourse(String name) {
        Course course = new Course();
        course.setName(name);
        courseRepository.save(course);
        return course;
    }

    @Override
    public String delete(Long id) {
        courseRepository.deleteById(id);
        return "deleted";
    }


}
