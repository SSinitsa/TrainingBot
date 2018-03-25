package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.TGMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TGMessageRepository extends JpaRepository<TGMessage, Long> {
}
