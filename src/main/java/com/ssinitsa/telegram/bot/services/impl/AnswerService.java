package com.ssinitsa.telegram.bot.services.impl;

import com.ssinitsa.telegram.bot.entity.Answer;
import com.ssinitsa.telegram.bot.repository.AnswerRepository;
import com.ssinitsa.telegram.bot.services.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnswerService extends AbstractEntityService<Answer> implements IAnswerService {

    @Autowired
    AnswerRepository repository;

}
