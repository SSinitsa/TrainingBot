package com.ssinitsa.telegram.bot.controllers;

import com.ssinitsa.telegram.bot.entity.Student;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController<Student> {

    @Autowired
    public StudentController(IAbstractEntityService<Student> studentService) {
        super(studentService);
    }
}
