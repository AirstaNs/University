package ru.usatu.students.service;

import org.springframework.stereotype.Component;
import ru.usatu.students.model.Student;
import java.util.List;

@Component
public interface StudentService {

    Student getStudents(int id) throws Exception;

    List<Student> getStudents() throws Exception;

    void deleteStudent(int id) throws Exception;

    Student editStudent(int id, String surname, String name, String patronymic, String number, String phone) throws Exception;

    Student addStudent(Student student) throws Exception;

}

