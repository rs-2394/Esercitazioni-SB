package com.example.esercitazione21_02.repository;

import com.example.esercitazione21_02.dominio.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
