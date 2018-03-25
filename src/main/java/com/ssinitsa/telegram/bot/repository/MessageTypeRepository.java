package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.MessageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageTypeRepository extends JpaRepository<MessageType, Long> {
}
