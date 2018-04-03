package com.ssinitsa.telegram.bot.controllers;

import com.ssinitsa.telegram.bot.entity.Test;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController<Test> {

    @Autowired
    public TestController(IAbstractEntityService<Test> testService) {
        super(testService);
    }
}
