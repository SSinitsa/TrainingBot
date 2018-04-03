package com.ssinitsa.telegram.bot.services;

import com.ssinitsa.telegram.bot.entity.Question;
import com.ssinitsa.telegram.bot.entity.Test;

public interface IQuestionServise extends IAbstractEntityService<Question> {

    Question nextQuestion(Question question, Test test);

}
