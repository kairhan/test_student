package com.example.students.service;

import com.example.students.model.Course;

public interface CourseService {
    Course addCourse(String name);

    String delete(Long id);
}
