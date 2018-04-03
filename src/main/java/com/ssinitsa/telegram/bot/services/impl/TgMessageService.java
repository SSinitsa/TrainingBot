package com.ssinitsa.telegram.bot.services.impl;

import com.ssinitsa.telegram.bot.entity.MessageType;
import com.ssinitsa.telegram.bot.entity.TgMessage;
import com.ssinitsa.telegram.bot.repository.TgMessageRepository;
import com.ssinitsa.telegram.bot.services.ITgMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TgMessageService extends AbstractEntityService<TgMessage> implements ITgMessageService {

    @Autowired
    TgMessageRepository repository;

    @Override
    public String getHelpMessage() {
        return repository.findByType(MessageType.START).getText();
    }
}
