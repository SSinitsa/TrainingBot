package com.ssinitsa.telegram.bot.controllers;

import com.ssinitsa.telegram.bot.entity.Result;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultController extends BaseController<Result> {

    @Autowired
    public ResultController(IAbstractEntityService<Result> resultService) {
        super(resultService);
    }
}
