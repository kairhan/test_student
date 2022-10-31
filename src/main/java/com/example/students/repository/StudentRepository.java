package com.example.students.repository;

import com.example.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    @Query(value = " select * from students" +
            " where age > 23",
            nativeQuery = true)
    List<Student> getAllStudentOlder23();

    @Query(value = " select * from students order by gpa desc" , nativeQuery = true)
    List<Student> getTopGpa();

    @Query(value ="select * from students where faculty_id = :facultyId " , nativeQuery = true)
    List<Student> findAllByFaculty(@Param("facultyId") Long facultyId);

    @Query(value ="select * from students where group_id = :groupId " , nativeQuery = true)
    List<Student> findAllGroup(@Param("groupId") Long groupId);

    @Query(value = "select * from students order by GPA" , nativeQuery = true)
    List<Student>orderByGPA();

    @Query(value = "select * from students order by full_name" , nativeQuery = true)
    List<Student>orderByName();



}





