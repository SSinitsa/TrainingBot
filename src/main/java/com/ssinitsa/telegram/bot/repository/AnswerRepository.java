package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
