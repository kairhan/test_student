package com.example.students.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(description = "сущность")
@Table(name = "studentCourse")

public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Column
    private double rk1;

    @Column
    private double rk2;

    @Column
    private double finalExam;

    @Column
    private double overAll;

    public double getOverAll() {
        return (rk1 + rk2 + finalExam) / 3.0;
    }

    public void setOverAll(double rk1, double rk2 , double finalExam) {
        this.overAll = (rk1 + rk2 + finalExam) / 3.0;
    }

}
