package ru.usatu.students.service;

import org.springframework.stereotype.Service;
import ru.usatu.students.model.Student;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.IntStream;

@Service
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

        // final List<String> group2 = List.of("Баландина О.А.", "Байбурин М.Р.", "Злыгостев А.А.", "Гареева Д.Р.");
        // final List<String> numbers = List.of("20130490", "20130834", "20130491", "20130486");
        //  IntStream.range(0, group2.size()).forEach(i -> students.add(new Student(i + 1, group2.get(i), numbers.get(i))));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudents(int id) {
//        for (var student : students) {
//            if (student.getId() == id)
//                return student;}
//        return new Student();
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(new Student());
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student editStudent(int id, String surname, String name, String patronymic, String number, String phone) {
//        for (var student : students) {
//            if (student.getId() == id) {
//                student.setName(name);
//                return student;
//            }}
//        return new Student();
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
        // students = students.stream().filter(student -> student.getId()!=id).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        StudentServiceCollection students = new StudentServiceCollection();
        students.deleteStudent(1);
    }
}
