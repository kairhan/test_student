package com.example.students.controller;



import com.example.students.model.Student;
import com.example.students.model.StudentCourse;
import com.example.students.model.dto.request.StudentCourseRequest;
import com.example.students.model.dto.response.StudentCourseResponse;
import com.example.students.service.StudentCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/studentCourse")
public class StudentCourseController {
    private final StudentCourseService studentCourseService;

    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @PostMapping("/addStCourse")
    public StudentCourse addStCourse(@RequestBody StudentCourseRequest studentCourseRequest) throws Exception {
        return studentCourseService.addStCourse(studentCourseRequest);
    }

    @DeleteMapping("/deleteStCourse")
    public void deleteById(Long id) {
        studentCourseService.deleteById(id);
    }

    @PostMapping("/update")
    public StudentCourse updateStudentCourse(@RequestBody StudentCourseRequest studentCourseRequest ,Long id) throws Exception {
        return studentCourseService.updateStudentCourse(studentCourseRequest, id);
    }

    @PostMapping("/getBySt")
    public List<StudentCourseResponse> getCourseByIdStudent (Long id){
        return studentCourseService.getCourseByIdStudent(id);
    }

    @PostMapping("/addStListToStudentCourse")
    public List<Long> addStListToStudentCourse(@RequestParam List<Long> ids ,
                                               @RequestParam Long id) throws Exception {
        return studentCourseService.addStListToStudentCourse(ids , id);
    }




}
