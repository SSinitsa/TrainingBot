package com.ssinitsa.telegram.bot.services.impl;

import com.ssinitsa.telegram.bot.entity.Student;
import com.ssinitsa.telegram.bot.repository.StudentRepository;
import com.ssinitsa.telegram.bot.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends AbstractEntityService<Student> implements IStudentService{

    @Autowired
    StudentRepository repository;

    @Override
    public Student findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
