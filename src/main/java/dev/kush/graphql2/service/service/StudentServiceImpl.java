package dev.kush.graphql2.service.service;

import dev.kush.graphql2.model.Laptop;
import dev.kush.graphql2.model.Student;
import dev.kush.graphql2.repository.LaptopRepository;
import dev.kush.graphql2.repository.StudentRepository;
import dev.kush.graphql2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return findStudentById(studentId);
    }
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(Long studentId) {
        Student student = findStudentById(studentId);
        studentRepository.delete(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        Student existingStudent = findStudentById(student.getStudentId());

        if (student.getFirstName() != null && !student.getFirstName().isEmpty()) {
            existingStudent.setFirstName(student.getFirstName());
        }

        if (student.getLastName()!= null &&!student.getLastName().isEmpty()) {
            existingStudent.setLastName(student.getLastName());
        }

        if (student.getEmail() != null && !student.getEmail().isEmpty()){
            existingStudent.setEmail(student.getEmail());
        }

        if (student.getPhoneNumber()!= null && !student.getPhoneNumber().isEmpty()){
            existingStudent.setPhoneNumber(student.getPhoneNumber());
        }
        return studentRepository.save(existingStudent);
    }

    @Override
    public Student assignLaptops(Long studentId, List<Long> laptopIds) {
        Student student = findStudentById(studentId);
        laptopIds.forEach(laptopId -> {
            Laptop laptop = findLaptopById(laptopId);
            student.getLaptops().add(laptop);
            laptop.setStudent(student);
        });
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findByPage(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return studentRepository.findAll(pageRequest).getContent();
    }

    private Student findStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Could not find student"));
    }

    private Laptop findLaptopById(Long laptopId) {
        return laptopRepository.findById(laptopId).orElseThrow(() -> new RuntimeException("Could not find laptop"));
    }
}
