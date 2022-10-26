package ru.usatu.students.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.usatu.students.model.Student;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //TODO заполнить

    interface CrudRepository<T, ID> extends Repository<T, ID> {
        <S extends T> S save(S entity);

        <S extends T> Iterable<S> saveAll(Iterable<S> entities);

        Optional<T> findById(ID id);

        boolean existsById(ID id);

        Iterable<T> findAll();

        Iterable<T> findAllById(Iterable<ID> ids);

        long count();

        void deleteById(ID id);

        void delete(T entity);

        void deleteAllById(Iterable<? extends ID> ids);

        void deleteAll(Iterable<? extends T> entities);

        void deleteAll();
    }

    interface Repository<T, ID> {}

    interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {
        Iterable<T> findAll(Sort sort);
        Page<T> findAll(Pageable pageable);
    }

//    @Override
//    List<Student> findAll();
}


