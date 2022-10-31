package com.example.students.controller;

import com.example.students.model.Student;
import com.example.students.model.dto.request.StudentAddPhoneNumberRequest;
import com.example.students.model.dto.request.StudentRequest;
import com.example.students.model.dto.response.GroupResponse;
import com.example.students.model.dto.response.StudentResponse;
import com.example.students.service.StudentsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/student")
public class StudentController {
    private final StudentsService studentsService;

    public StudentController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping("/addWithRequest")
    public Student addStudentRequest(@RequestBody StudentRequest studentRequest){
        return studentsService.addStudentWithRequest(studentRequest);
    }

    @PostMapping("/addPhoneNumber")
    public Student addPhoneNumber(@RequestBody StudentAddPhoneNumberRequest studentAddPhoneNumberRequest){
        return studentsService.addPhoneNumber(studentAddPhoneNumberRequest);
    }

    @PostMapping("/getById")
    public Student getById(Long id) throws Exception {
        Student student = studentsService.getById(id);
        return student;
    }


    @PostMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentsService.updateStudent(student);
    }

    @PostMapping("/stackGroupWithStudents")
    public Student stackGroupWithStudents(Long studentID , Long groupId){
        return studentsService.stackGroupWithStudents(studentID , groupId);
    }

    @GetMapping ("/getAllWithResponses")
    public List<StudentResponse> getAllStudentResponse (){
         List<StudentResponse> studentsResponses = studentsService.getAllWithResponse();
         return studentsResponses;
    }

    @DeleteMapping("/deleteStudent")
        public void deleteById(Long id){
        studentsService.deleteById(id);
    }

    @GetMapping("/getOlder23")
    public List<StudentResponse>getAllStudentOlder23(){
        return studentsService.getAllStudentOlder23();
    }

    @GetMapping("/getOlder23WithResponse")
    public List<StudentResponse>getAllStudentsOlder23(){
        List<StudentResponse> studentResponses = studentsService.getAllStudentsOlder23WithResponse();
        return studentResponses;
    }

    @GetMapping("/getTopGpa")
    public  List<Student>getTopGpa(){
        return studentsService.getTopGpa();
    }

    @GetMapping("/findAllByFaculty")
    public List<StudentResponse>getFacultyIT(Long id) {
        return studentsService.findAllByFaculty(id);
    }

    @GetMapping("/getByGroup")
    public List<StudentResponse> getByGroup(Long id){
        return studentsService.getByGroup(id);
        }

    @GetMapping("/orderByGPA")
    public List<StudentResponse>orderByGPA() {
        return studentsService.sortGPA();
    }

    @GetMapping("/orderByName")
    public List<StudentResponse>orderByName() {
        return studentsService.sortName();
    }
    }
