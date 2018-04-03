package com.ssinitsa.telegram.bot.controllers;

import com.ssinitsa.telegram.bot.entity.Materials;
import com.ssinitsa.telegram.bot.entity.Question;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController extends BaseController<Question> {

    @Autowired
    public QuestionController(IAbstractEntityService<Question> questionService) {
        super(questionService);
    }
}
