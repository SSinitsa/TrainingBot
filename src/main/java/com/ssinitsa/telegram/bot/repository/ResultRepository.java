package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
