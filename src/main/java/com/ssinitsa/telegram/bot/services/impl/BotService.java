package com.ssinitsa.telegram.bot.services.impl;

import com.ssinitsa.telegram.bot.entity.Bot;
import com.ssinitsa.telegram.bot.entity.Question;
import com.ssinitsa.telegram.bot.entity.Test;
import com.ssinitsa.telegram.bot.repository.BotRepository;
import com.ssinitsa.telegram.bot.services.IBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotService extends AbstractEntityService<Bot> implements IBotService {

   @Autowired
    BotRepository repository;

    @Override
    public Bot findByName(String name) {
        return repository.findByName(name);
    }

}
