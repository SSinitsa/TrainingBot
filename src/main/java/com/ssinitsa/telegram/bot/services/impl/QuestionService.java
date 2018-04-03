package com.ssinitsa.telegram.bot.services.impl;

import com.ssinitsa.telegram.bot.entity.Question;
import com.ssinitsa.telegram.bot.entity.Test;
import com.ssinitsa.telegram.bot.repository.QuestionRepository;
import com.ssinitsa.telegram.bot.services.IQuestionServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends AbstractEntityService<Question> implements IQuestionServise {

    @Autowired
    QuestionRepository repository;

    @Override
    public Question nextQuestion(Question question, Test test) {
        return repository.findByTestAndNumber(test, question.getNumber()+1);
    }
}
