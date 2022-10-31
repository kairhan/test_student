package com.example.students.service;

import com.example.students.model.Group;
import com.example.students.model.Student;
import com.example.students.model.dto.request.StudentAddPhoneNumberRequest;
import com.example.students.model.dto.request.StudentRequest;
import com.example.students.model.dto.response.GroupResponse;
import com.example.students.model.dto.response.StudentResponse;

import java.util.List;

public interface StudentsService {

    Student addStudentWithRequest(StudentRequest studentRequest);

    Student addPhoneNumber(StudentAddPhoneNumberRequest studentAddPhoneNumberRequest);

    Student updateStudent(Student student);

    List<StudentResponse>getAllWithResponse();

    List<StudentResponse>getAllStudentOlder23();

    List<StudentResponse>getAllStudentsOlder23WithResponse();

    List<Student>getTopGpa();

    List<StudentResponse> findAllByFaculty(Long id);

    Student getById (Long id) throws Exception;

    Student stackGroupWithStudents (Long studentId , Long groupId);

    void deleteById(Long id);

    List<StudentResponse> getByGroup(Long id);

    List<StudentResponse>sortGPA();

    List<StudentResponse>sortName();
}
