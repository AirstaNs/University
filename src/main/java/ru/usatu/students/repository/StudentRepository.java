package ru.usatu.students.repository;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import ru.usatu.students.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Override
    List<Student> findAll();

    @Override
    List<Student> findAllById(Iterable<Integer> integers);

    @Override
    <S extends Student> List<S> saveAll(Iterable<S> entities);

    @Override
    void flush();

    @Override
    <S extends Student> S saveAndFlush(S entity);

    @Override
    <S extends Student> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<Student> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);

    @Override
    void deleteAllInBatch();

    @Override
    Student getOne(Integer integer);

    @Override
    Student getById(Integer integer);

    @Override
    <S extends Student> List<S> findAll(Example<S> example);

    @Override
    <S extends Student> List<S> findAll(Example<S> example, Sort sort);

    @Override
    Page<Student> findAll(Pageable pageable);

    @Override
    <S extends Student> S save(S entity);

    @Override
    Optional<Student> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Student entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends Student> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Student> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Student> long count(Example<S> example);

    @Override
    <S extends Student> boolean exists(Example<S> example);

    @Override
    <S extends Student, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    @Override
    List<Student> findAll(Sort sort);
}



