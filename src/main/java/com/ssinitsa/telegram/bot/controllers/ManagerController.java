package com.ssinitsa.telegram.bot.controllers;

import com.ssinitsa.telegram.bot.entity.Manager;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController extends BaseController<Manager> {

    @Autowired
    public ManagerController(IAbstractEntityService<Manager> managerService) {
        super(managerService);
    }
}
