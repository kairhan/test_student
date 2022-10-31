package com.example.students.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(description = "сущность")
@Table(name = "faculty")

public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "student_id", referencedColumnName = "id")
//    private Student StudentId;
}
