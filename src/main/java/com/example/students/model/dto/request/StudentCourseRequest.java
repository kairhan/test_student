package com.example.students.model.dto.request;

import lombok.Data;

@Data
public class StudentCourseRequest {
    private Long id;

    private Long studentId;

    private Long courseId;

    private double rk1;

    private double rk2;

    private double finalExam;

    private double overAll;

}
