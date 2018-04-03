package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByUsername (String username);

}
