package dev.kush.graphql2.service;

import dev.kush.graphql2.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long studentId);
    Student createStudent(Student student);
    Student deleteStudent(Long studentId);
    Student updateStudent(Student student);

    Student assignLaptops(Long studentId,List<Long> laptopIds);

    List<Student> findByPage(Integer page,Integer size);
}
