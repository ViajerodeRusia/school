package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //TODO: для получения всех студентов, возраст которых находится в промежутке, пришедшем в запросе
    Collection<Student> findByAgeBetween(int min, int max);
}
