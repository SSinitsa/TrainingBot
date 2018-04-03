package com.ssinitsa.telegram.bot.controllers;

import com.ssinitsa.telegram.bot.entity.UserAttachment;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attachment")
public class AttachmentController extends BaseController<UserAttachment> {

    @Autowired
    public AttachmentController(IAbstractEntityService<UserAttachment> attachmentService) {
        super(attachmentService);
    }
}
