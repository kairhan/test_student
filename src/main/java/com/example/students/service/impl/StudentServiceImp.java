package com.example.students.service.impl;

import com.example.students.model.Group;
import com.example.students.model.Student;
import com.example.students.model.dto.request.StudentAddPhoneNumberRequest;
import com.example.students.model.dto.request.StudentRequest;
import com.example.students.model.dto.response.StudentResponse;
import com.example.students.repository.FacultyRepository;
import com.example.students.repository.GroupRepository;
import com.example.students.repository.StudentRepository;
import com.example.students.service.StudentsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentsService {
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;
    private final GroupRepository groupRepository;

    public StudentServiceImp(StudentRepository studentRepository, FacultyRepository facultyRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public Student addStudentWithRequest(StudentRequest studentRequest) {
        Student student = new Student();
        student.setRegion(studentRequest.getRegion());
        student.setFullName(studentRequest.getFullName());
        student.setAge(studentRequest.getAge());
        student.setPhoneNumber(String.join(",", studentRequest.getPhoneNumber()));
        student.setFaculty(facultyRepository.findById(studentRequest.getFacultyId()).get());
        student.setGroup(groupRepository.findById(studentRequest.getGroupId()).get());
        studentRepository.save(student);
        return student;
    }


    @Override
    public Student addPhoneNumber(StudentAddPhoneNumberRequest studentAddPhoneNumberRequest) {
        Optional<Student> studentOptional = studentRepository.findById(studentAddPhoneNumberRequest.getId());
        if (!studentOptional.isPresent()) {
            return null;
        }
        Student student = studentOptional.get();
        List<String> al = new ArrayList<>();
        if (student.getPhoneNumber() != null) {
            al.addAll(Arrays.asList(student.getPhoneNumber().split(",")));
        }
        al.addAll(studentAddPhoneNumberRequest.getPhoneNumber());
        studentAddPhoneNumberRequest.setPhoneNumber(al);
        student.setPhoneNumber(String.join(",", al));
        studentRepository.save(student);
        return student;

    }

    @Override
    public Student stackGroupWithStudents(Long studentId, Long groupId) {
        Student student = studentRepository.findById(studentId).get();
        Group group = groupRepository.findById(groupId).get();
        student.setGroup(group);
        studentRepository.save(student);
        return student;
    }


    @Override
    public List<StudentResponse> getAllWithResponse() {
        return convertStudentListToResponse(studentRepository.findAll());
    }

    private List<StudentResponse> convertStudentListToResponse(List<Student> studentList) {
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for (Student student : studentList) {
            StudentResponse studentResponse = convertStudentToResponse(student);
            studentResponseList.add(studentResponse);
        }
        return studentResponseList;
    }


    private StudentResponse convertStudentToResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setFullName(student.getFullName());
        studentResponse.setAge(student.getAge());
        studentResponse.setRegion(student.getRegion());
        studentResponse.setGPA(student.getGPA());
        if (student.getPhoneNumber() != null) {
            studentResponse.setPhoneNumber(List.of(student.getPhoneNumber().split(",")));
        }
        studentResponse.setFaculty(student.getFaculty().getName());
        if (student.getGroup() != null) {
            studentResponse.setGroupId(student.getGroup().getId());
            studentResponse.setGroupName(student.getGroup().getName());
        }
        return studentResponse;
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<StudentResponse> getAllStudentOlder23() {
        return convertStudentListToResponse(studentRepository.getAllStudentOlder23());
    }

    @Override
    public List<StudentResponse> getAllStudentsOlder23WithResponse() {
        return convertStudentListToResponse(studentRepository.getAllStudentOlder23());
    }

    @Override
    public Student getById(Long id) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(() -> new Exception("такого студента нет: " + id));
        return student;
    }


    @Override
    public List<Student> getTopGpa() {
        return studentRepository.getTopGpa();
    }

    @Override
    public List<StudentResponse> findAllByFaculty(Long id) {
        return convertStudentListToResponse(studentRepository.findAllByFaculty(id));
    }

    @Override
    public List<StudentResponse> getByGroup(Long id) {
        return convertStudentListToResponse(studentRepository.findAllGroup(id));
    }

    @Override
    public List<StudentResponse>sortGPA(){
        return convertStudentListToResponse(studentRepository.orderByGPA());
    }

    @Override
    public List<StudentResponse>sortName(){
        return convertStudentListToResponse(studentRepository.orderByName());
    }
}

