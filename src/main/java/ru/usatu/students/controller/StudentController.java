package ru.usatu.students.controller;

import com.github.lambdaexpression.annotation.EnableRequestBodyParam;
import com.github.lambdaexpression.annotation.RequestBodyParam;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.usatu.students.model.Student;
import ru.usatu.students.service.StudentService;

//import ru.usatu.students.service.StudentServiceCollection;
import java.util.List;

@CrossOrigin
@RestController
@Component
@EnableRequestBodyParam
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
   public StudentController(StudentService studentService) {this.studentService = studentService;}

    @GetMapping
    public @ResponseBody
    List<Student> getStudents() {
        try {
            return studentService.getStudents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Student getStudent(@PathVariable int id) {
        try {
            return studentService.getStudent(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public @ResponseBody
    Student addStudent(@RequestBody Student student) {
        try {
            return studentService.addStudent(student);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Student editStudent(@PathVariable int id, @RequestBodyParam String surname, @RequestBodyParam String name, @RequestBodyParam String patronymic, @RequestBodyParam String number, @RequestBodyParam String phone) {
        try {
            return studentService.editStudent(id, surname, name, patronymic, number, phone);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable int id) {
        try {
            studentService.deleteStudent(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
