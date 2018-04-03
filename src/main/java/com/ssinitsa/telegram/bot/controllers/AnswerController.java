package com.ssinitsa.telegram.bot.controllers;

import com.ssinitsa.telegram.bot.entity.Answer;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
public class AnswerController extends BaseController<Answer> {

    @Autowired
    public AnswerController(IAbstractEntityService<Answer> answerService) {
        super(answerService);
    }
}
