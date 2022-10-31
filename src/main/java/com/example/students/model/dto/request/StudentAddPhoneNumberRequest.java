package com.example.students.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentAddPhoneNumberRequest {
    private Long id;

    private List<String> phoneNumber;
}
