package com.example.students.repository;

import com.example.students.model.Course;
import com.example.students.model.Student;
import com.example.students.model.StudentCourse;
import com.example.students.model.dto.response.StudentCourseResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse,Long> {

    @Query(value ="select * from student_course where student_id = :studentId " , nativeQuery = true)
    List<StudentCourse> findAllByStudentId(@Param("studentId") Long studentId);
}
