package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(@Autowired StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}") //GET https://localhost:8080/students/23
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student foundStudent = studentService.findStudent(id);
        if(foundStudent == null) {
            // 404
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }
    @PostMapping //POST https://localhost:8080/students
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping //PUT https://localhost:8080/students
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if(foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @GetMapping //GET https://localhost:8080/students
    public ResponseEntity<Collection<Student>> getAllStudents(@RequestParam(required = false) Integer min,
                                                              @RequestParam(required = false) Integer max) {
        System.out.println("min: " + min); // Добавляем эту строку для проверки
        System.out.println("max: " + max); // Добавляем эту строку для проверки
        if(min != null && max != null) {
            return ResponseEntity.ok(studentService.findStudentByAge(min, max));
        }
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @DeleteMapping("{id}") //DELETE https://localhost:8080/students
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
