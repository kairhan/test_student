package com.example.students.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentRequest {

    private String fullName;

    private Long facultyId;

    private int age;

    private String region;

    private double GPA;

    private Long groupId;

    private List<String> phoneNumber;

}
