package com.example.students.service;

import com.example.students.model.StudentCourse;
import com.example.students.model.dto.request.StudentCourseRequest;
import com.example.students.model.dto.response.StudentCourseResponse;

import java.util.List;

public interface StudentCourseService {
    StudentCourse addStCourse(StudentCourseRequest studentCourseRequest) throws Exception;

    void deleteById(Long id) ;

    StudentCourse updateStudentCourse(StudentCourseRequest request  ,Long id) throws Exception;

    List<StudentCourseResponse> getCourseByIdStudent(Long id);

    List<Long> addStListToStudentCourse(List<Long> ids , Long id) throws Exception;
}
