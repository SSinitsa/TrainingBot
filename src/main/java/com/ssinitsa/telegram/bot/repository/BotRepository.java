package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.Bot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BotRepository extends JpaRepository<Bot, Long> {
}
