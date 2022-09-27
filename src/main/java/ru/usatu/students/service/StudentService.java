package ru.usatu.students.service;

import ru.usatu.students.model.Student;
import java.util.List;

public interface StudentService {

    Student getStudents(int id);

    List<Student> getStudents();

    void deleteStudent(int id);

    Student editStudent(int id, String name);

    Student addStudent(Student student);
}
