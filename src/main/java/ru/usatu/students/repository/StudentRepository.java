package ru.usatu.students.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.usatu.students.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //TODO заполнить
    @Override
    List<Student> findAll();
}


