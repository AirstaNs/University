package ru.usatu.students.service;

import org.springframework.stereotype.Service;
import ru.usatu.students.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class StudentServiceCollection {
    private List<Student> students = new ArrayList<>();

    public StudentServiceCollection() {
        String std = "student";
        final List<String> group2 = List.of("Баландина О.А.", "Байбурин М.Р.", "Злыгостев А.А.", "Гареева Д.Р.");
        IntStream.range(0, group2.size()).forEach(i -> students.add(new Student(i + 1, group2.get(i))));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudents(int id) {
//        for (var student : students) {
//            if (student.getId() == id)
//                return student;
//        }
//        return new Student();
//
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(new Student());
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student editStudent(int id, String name) {
//        for (var student : students) {
//            if (student.getId() == id) {
//                student.setName(name);
//                return student;
//            }
//        }
//        return new Student();
        return students.stream().filter(student -> student.getId() == id).findFirst().map(student -> {
            student.setName(name);
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
