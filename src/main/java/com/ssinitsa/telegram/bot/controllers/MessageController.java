package com.ssinitsa.telegram.bot.controllers;

import com.ssinitsa.telegram.bot.entity.TgMessage;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController extends BaseController<TgMessage> {

    @Autowired
    public MessageController(IAbstractEntityService<TgMessage> messageService) {
        super(messageService);
    }
}
