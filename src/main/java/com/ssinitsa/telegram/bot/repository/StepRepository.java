package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}
