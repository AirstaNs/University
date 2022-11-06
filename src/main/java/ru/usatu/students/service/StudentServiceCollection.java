package ru.usatu.students.service;
import ru.usatu.students.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceCollection implements StudentService{
   private List<Student> students = new ArrayList<>();

    public StudentServiceCollection() {
        String std = "student";
        students.add(new Student(1, "Баландина", "Ольга", "Андреевна",
                                "20130490","89374786563"));
        students.add(new Student(2, "Байбурин", "Марат", "Рашидович",
                                "20130834", "8800553535"));
        students.add(new Student(3, "Злыгостев", "Артем", "Андреевич",
                                 "20130491", "89374444444"));
        students.add(new Student(4, "Гареева", "Диана", "Радиковна",
                                 "20130486", "89374786555"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent (int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(new Student());
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student editStudent(int id, String surname, String name, String patronymic, String number, String phone) {
        return students.stream().filter(student -> student.getId() == id).findFirst().map(student -> {
            student.setSurName(surname);
            student.setName(name);
            student.setPatronymic(patronymic);
            student.setNumber(number);
            student.setPhone(phone);
            return student;
        }).orElse(new Student());
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public static void main(String[] args) {
        StudentServiceCollection students = new StudentServiceCollection();
        students.deleteStudent(1);
    }
}
