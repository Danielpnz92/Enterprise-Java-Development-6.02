package Lab62.controller;

import Lab62.Repository.StudentRepository;
import Lab62.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    public StudentRepository studentRepository;

    @GetMapping("/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentInfo(@PathVariable String studentId){
        return studentRepository.findById(studentId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }
}
