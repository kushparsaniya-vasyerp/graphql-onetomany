package dev.kush.graphql2.controller;

import dev.kush.graphql2.model.Student;
import dev.kush.graphql2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @QueryMapping(value = "allStudents")
    private List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @QueryMapping(value = "findStudent")
    private Student getStudentById(@Argument Long studentId){
        return studentService.getStudentById(studentId);
    }

    @QueryMapping(value = "allStudentPages")
    private List<Student> findByPage(@Argument Integer page, @Argument Integer size){
        return studentService.findByPage(page, size);
    }

    @MutationMapping(value = "addStudent")
    private Student createStudent(@Argument Student student){
        return studentService.createStudent(student);
    }

    @MutationMapping(value = "updateStudent")
    private Student updateStudent(@Argument Student student){
        return studentService.updateStudent(student);
    }

    @MutationMapping(value = "deleteStudent")
    private Student deleteStudent(@Argument Long studentId){
        return studentService.deleteStudent(studentId);
    }

    @MutationMapping(value = "assignLaptops")
    private Student assignLaptops(@Argument Long studentId, @Argument List<Long> laptopIds){
        return studentService.assignLaptops(studentId, laptopIds);
    }

}
