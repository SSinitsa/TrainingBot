package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.Question;
import com.ssinitsa.telegram.bot.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByTestAndNumber (Test test, int number);

}
