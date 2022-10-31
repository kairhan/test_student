package com.example.students.model.dto.response;

import com.example.students.model.Faculty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private String fullName;

    private String faculty;

    private int age;

    private String region;

    private double GPA;

    private Long groupId;

    private String groupName;

    private List<String> phoneNumber;
}
