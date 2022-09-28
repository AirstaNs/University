package ru.usatu.students.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.usatu.students.model.Student;
import ru.usatu.students.service.StudentService;

//import ru.usatu.students.service.StudentServiceCollection;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    //private StudentServiceCollection studentService;
    private StudentService studentService;

   //public StudentController(StudentServiceCollection studentService) {this.studentService = studentService;}
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
    Student getStudents(@PathVariable int id) {
        try {
            return studentService.getStudents(id);
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
    Student editStudent(@PathVariable int id, @RequestBody String surname, @RequestBody String name, @RequestBody String patronymic, @RequestBody String number,@RequestBody String phone) {
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
