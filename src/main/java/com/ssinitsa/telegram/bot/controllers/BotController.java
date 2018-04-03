package com.ssinitsa.telegram.bot.controllers;

import com.ssinitsa.telegram.bot.entity.Bot;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bot")
public class BotController extends BaseController<Bot> {

    @Autowired
    public BotController(IAbstractEntityService<Bot> botService) {
        super(botService);
    }
}
