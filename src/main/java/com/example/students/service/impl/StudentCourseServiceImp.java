package com.example.students.service.impl;

import com.example.students.model.Course;
import com.example.students.model.StudentCourse;
import com.example.students.model.dto.request.StudentCourseRequest;
import com.example.students.model.dto.response.StudentCourseResponse;
import com.example.students.repository.CourseRepository;
import com.example.students.repository.StudentCourseRepository;
import com.example.students.service.StudentCourseService;
import com.example.students.service.StudentsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseServiceImp implements StudentCourseService {
    private final StudentCourseRepository studentCourseRepository;
    private final CourseRepository courseRepository;
    private final StudentsService studentService;

    public StudentCourseServiceImp(StudentCourseRepository studentCourseRepository, CourseRepository courseRepository, StudentsService studentService) {
        this.studentCourseRepository = studentCourseRepository;
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }


    @Override
    public StudentCourse addStCourse(StudentCourseRequest studentCourseRequest) throws Exception {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setRk1(studentCourseRequest.getRk1());
        studentCourse.setRk2(studentCourseRequest.getRk2());
        studentCourse.setFinalExam(studentCourseRequest.getFinalExam());
        studentCourse.setOverAll(studentCourseRequest.getRk1(), studentCourseRequest.getRk2(), studentCourseRequest.getFinalExam());
        studentCourse.setCourse(courseRepository.findById(studentCourseRequest.getCourseId()).orElseThrow(() -> new Exception("такого курса нет: " + studentCourseRequest.getCourseId())));
        studentCourse.setStudent(studentService.getById(studentCourseRequest.getStudentId()));
        studentCourseRepository.save(studentCourse);
        return studentCourse;
    }

    @Override
    public void deleteById(Long id) {
        studentCourseRepository.deleteById(id);
    }

    @Override
    public StudentCourse updateStudentCourse(StudentCourseRequest request ,Long id) throws Exception {
    StudentCourse studentCourse = studentCourseRepository.findById(id).orElseThrow(() -> new Exception("такого курса нет: " + id));
        studentCourse.setRk1(request.getRk1());
        studentCourse.setRk2(request.getRk2());
        studentCourse.setFinalExam(request.getFinalExam());
        studentCourse.setOverAll(request.getRk1(), request.getRk2(), request.getFinalExam());
        studentCourse.setCourse(courseRepository.findById(request.getCourseId()).orElseThrow(() -> new Exception("такого курса нет: " + request.getCourseId())));
        studentCourse.setStudent(studentService.getById(request.getStudentId()));
        studentCourseRepository.save(studentCourse);
        return studentCourse ;
    }

    @Override
    public List<StudentCourseResponse> getCourseByIdStudent(Long id) {
        return convertStudentListToResponse(studentCourseRepository.findAllByStudentId(id));
    }

    @Override
    public List<Long> addStListToStudentCourse(List<Long> ids , Long id) throws Exception {
        for (Long studentId : ids){
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setCourse(courseRepository.findById(id).orElseThrow(() -> new Exception("такого курса нет: " + id)));
            studentCourse.setStudent(studentService.getById(studentId));
            studentCourse.setRk1(0);
            studentCourse.setRk2(0);
            studentCourse.setFinalExam(0);
            studentCourse.setOverAll(0);
            studentCourseRepository.save(studentCourse);
        }
        return ids;
    }

    private StudentCourseResponse convertStudentCourseToResponse(StudentCourse studentCourse) {
        StudentCourseResponse studentCourseResponse = new StudentCourseResponse();
        studentCourseResponse.setCourseName(studentCourse.getCourse().getName());
        studentCourseResponse.setRk1(studentCourse.getRk1());
        studentCourseResponse.setRk2(studentCourse.getRk2());
        studentCourseResponse.setFinalExam(studentCourse.getFinalExam());
        studentCourseResponse.setOverAll(studentCourse.getOverAll());

        return studentCourseResponse;
    }

    private List<StudentCourseResponse> convertStudentListToResponse(List<StudentCourse> studentCourseList) {
        List<StudentCourseResponse> studentCourseResponseList = new ArrayList<>();
        for (StudentCourse studentCourse : studentCourseList) {
            StudentCourseResponse studentResponse = convertStudentCourseToResponse(studentCourse);
            studentCourseResponseList.add(studentResponse);
        }
        return studentCourseResponseList;
    }
}
