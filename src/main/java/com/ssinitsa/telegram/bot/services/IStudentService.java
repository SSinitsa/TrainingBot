package com.ssinitsa.telegram.bot.services;

import com.ssinitsa.telegram.bot.entity.Student;

public interface IStudentService extends IAbstractEntityService<Student> {

    Student findByUsername(String username);

}
