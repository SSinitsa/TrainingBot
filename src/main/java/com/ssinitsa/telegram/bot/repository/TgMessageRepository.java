package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.MessageType;
import com.ssinitsa.telegram.bot.entity.TgMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TgMessageRepository extends JpaRepository<TgMessage, Long> {

    TgMessage findByType (MessageType type);
}
