package ru.usatu.students.service;

import org.springframework.stereotype.Service;
import ru.usatu.students.model.Student;
import ru.usatu.students.repository.StudentRepository;

import java.util.List;
@Service
public class StudentServiceDb implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceDb(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(int id) throws Exception {
        return studentRepository.findById(id).orElse(new Student());
    }

    @Override
    public List<Student> getStudents() throws Exception {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        studentRepository.deleteById(id);

    }

    @Override
    public Student editStudent(int id, String surname, String name, String patronymic, String number, String phone) throws Exception {
        Student findStudent = getStudent (id);

        findStudent.setName(name);
        findStudent.setSurName(surname);
        findStudent.setPatronymic(patronymic);
        findStudent.setNumber(number);
        findStudent.setPhone(phone);

        return studentRepository.save(findStudent);
    }

    @Override
    public Student addStudent(Student student) throws Exception {
        return studentRepository.save(student);
    }
}
